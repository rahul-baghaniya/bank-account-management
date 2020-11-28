package com.cybrilla.bankaccountmanagement.service;

import com.cybrilla.bankaccountmanagement.exception.ResourceNotFoundException;
import com.cybrilla.bankaccountmanagement.model.*;
import com.cybrilla.bankaccountmanagement.repository.AccountRepo;
import com.cybrilla.bankaccountmanagement.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    public ResponseEntity<String> makeTransaction(TransactionRequest transactionRequest, long accountId) {
        Optional<Account> customerAccount = accountRepo.findById(accountId);
        Transaction transaction = new Transaction();
        BigDecimal currentBalance = customerAccount.get().getBalance();


        transaction.setAmount(transactionRequest.getAmount());
        transaction.setDate(new Date());
        transaction.setDescription(transactionRequest.getDescription());
        transaction.setType(TransactionType.valueOf(transactionRequest.getTransactionType()));

        if(transactionRequest.getTransactionType().equals(TransactionType.DEBIT.name())) {
            BigDecimal newBalance = currentBalance.subtract(transactionRequest.getAmount());
            if (newBalance.compareTo(BigDecimal.ZERO) >= 0) {
                customerAccount.get().setBalance(newBalance);
                transaction.setBalance(newBalance);
                transaction.setAccount(customerAccount.get());
                accountRepo.save(customerAccount.get());
                transactionRepo.save(transaction);

                return new ResponseEntity<>("Account was debited", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Insufficient fund", HttpStatus.EXPECTATION_FAILED);
            }
        }else if (transactionRequest.getTransactionType().equals(TransactionType.CREDIT.name())){
            BigDecimal newBalance = currentBalance.add(transactionRequest.getAmount());
            customerAccount.get().setBalance(newBalance);
            transaction.setBalance(newBalance);
            transaction.setAccount(customerAccount.get());
            accountRepo.save(customerAccount.get());
            transactionRepo.save(transaction);
            return new ResponseEntity<>("Account was credited", HttpStatus.OK);
        }else {
            return null;
        }
    }

    public ResponseEntity<TransactionSummary> viewAccountSummary(long accountId) {
        TransactionSummary transactionSummary = new TransactionSummary();
        CustomerDetails customerDetails = new CustomerDetails();
        Optional<Account> customerAccount = accountRepo.findById(accountId);
        if(customerAccount.isEmpty()){
            throw new ResourceNotFoundException("Account does not exists for accountId " +accountId);
        }else{
            customerDetails.setName(customerAccount.get().getCustomer().getName());
            customerDetails.setEmail(customerAccount.get().getCustomer().getEmail());
            customerDetails.setAccountType(customerAccount.get().getAccountType());
            customerDetails.setBalance(customerAccount.get().getBalance());
            customerDetails.setLastName(customerAccount.get().getCustomer().getLastName());
        }
        Optional<List<Transaction>> transactionList =  transactionRepo.findByAccountId(accountId);
        List<TransactionResponse> transactionResponseList = new ArrayList<>();

        transactionSummary.setCustomerDetails(customerDetails);
        if(transactionList.isEmpty()){
            throw new ResourceNotFoundException("Transaction does not exists for accountId " +accountId);
        }else{
            for (Transaction t: transactionList.get()){
                TransactionResponse transactionResponse = new TransactionResponse();
                transactionResponse.setAmount(t.getAmount());
                transactionResponse.setBalance(t.getBalance());
                transactionResponse.setDate(t.getDate());
                transactionResponse.setDescription(t.getDescription());
                transactionResponse.setTransactionType(t.getType().name());
                transactionResponseList.add(transactionResponse);
            }
            transactionSummary.setTransactions(transactionResponseList);
            return new ResponseEntity<>(transactionSummary, HttpStatus.FOUND);
        }


    }


}
