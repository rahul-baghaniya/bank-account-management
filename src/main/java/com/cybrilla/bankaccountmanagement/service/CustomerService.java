package com.cybrilla.bankaccountmanagement.service;

import com.cybrilla.bankaccountmanagement.exception.BadRequestException;
import com.cybrilla.bankaccountmanagement.exception.ResourceNotFoundException;
import com.cybrilla.bankaccountmanagement.model.Account;
import com.cybrilla.bankaccountmanagement.model.AccountStatus;
import com.cybrilla.bankaccountmanagement.model.AccountType;
import com.cybrilla.bankaccountmanagement.model.Customer;
import com.cybrilla.bankaccountmanagement.repository.AccountRepo;
import com.cybrilla.bankaccountmanagement.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
   @Autowired
   private CustomerRepo customerRepo;

   @Autowired
   private AccountRepo accountRepo;

    public ResponseEntity<Customer> addNewCustomer(Customer customer) {
        Optional<Customer> customer1 = customerRepo.findByName(customer.getName());
        if(customer1.isEmpty()){
            Customer result = customerRepo.save(customer);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else {
            throw new BadRequestException("Customer already exists with name "+customer.getName());
        }

    }

    public ResponseEntity<Customer> findCustomerByName(String customerName) {
        Customer result = customerRepo.findByName(customerName).get();
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }

    public ResponseEntity<Account> addAccountForCustomer(Account account) {
        Account result = null;
            String customerName = account.getCustomer().getName();
            Optional<Customer> customer = customerRepo.findByName(customerName);
            if(customer.isEmpty()){
                   throw new ResourceNotFoundException("Customer", "name", customerName);
            }else{
                account.setCustomer(customer.get());
                result =  accountRepo.save(account);
            }
            return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    public ResponseEntity<Account> manageCustomerStatus(long accountId, String newAccountStatus) {
        Optional<Account> account = accountRepo.findById(accountId);
        if(account.isEmpty()){
            throw new ResourceNotFoundException("Account", "accountId", accountId);
        }else{
            account.get().setStatus(AccountStatus.valueOf(newAccountStatus));
           return new ResponseEntity<>(accountRepo.save(account.get()), HttpStatus.CREATED) ;
        }
    }

    public ResponseEntity<Account> viewCustomerAccount(long accountId) {
        Optional<Account> account = accountRepo.findById(accountId);
        if(account.isEmpty()){
            throw new ResourceNotFoundException("Account", "accountId", accountId);
        }else{
            return new ResponseEntity<>(account.get(), HttpStatus.FOUND) ;
        }
    }


    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountRepo.findAll();
        if(accounts.isEmpty()){
            throw new EntityNotFoundException();
        }
        else {
            return new ResponseEntity<>(accounts, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<BigDecimal> viewBalance(long customerId, String accountType) {
        AccountType accountType1 = AccountType.valueOf(accountType);
        Optional<Account> account = accountRepo.findByCustomerIdAndAccountType(customerId, accountType1);
        if(account.isEmpty()){
            throw new ResourceNotFoundException("Customer", "customerId", customerId);
        }else{
            return new ResponseEntity<>(account.get().getBalance(),HttpStatus.FOUND);
        }


    }
}
