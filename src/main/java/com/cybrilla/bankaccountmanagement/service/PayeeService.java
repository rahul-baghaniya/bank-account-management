package com.cybrilla.bankaccountmanagement.service;

import com.cybrilla.bankaccountmanagement.exception.BadRequestException;
import com.cybrilla.bankaccountmanagement.model.Account;
import com.cybrilla.bankaccountmanagement.model.AddPayeeDTO;
import com.cybrilla.bankaccountmanagement.model.Customer;
import com.cybrilla.bankaccountmanagement.model.Payee;
import com.cybrilla.bankaccountmanagement.repository.AccountRepo;
import com.cybrilla.bankaccountmanagement.repository.CustomerRepo;
import com.cybrilla.bankaccountmanagement.repository.PayeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayeeService {

    @Autowired
    private PayeeRepo payeeRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CustomerRepo customerRepo;


    public ResponseEntity<Payee> addPayee(AddPayeeDTO addPayeeDTO) {
        Optional<Account> payeeAccount = accountRepo.findById(addPayeeDTO.getPayeeAccountId());
        Optional<Customer> customer = customerRepo.findById(addPayeeDTO.getCustomerId());

        if(payeeAccount.isEmpty()){
            throw new BadRequestException("Payee account number is not correct");
        }else{
            Optional<Payee> payee1 = payeeRepo.findByPayeeAccountId(addPayeeDTO.getPayeeAccountId());
            if(payee1.isEmpty()){
                Payee input = new Payee();
                input.setCustomer(customer.get());
                input.setPayeeAccountId(addPayeeDTO.getPayeeAccountId());
                input.setPayeeName(addPayeeDTO.getPayeeName());
                return new ResponseEntity<>(payeeRepo.save(input), HttpStatus.CREATED);
            }else{
                throw new BadRequestException("Payee already exists");
            }

        }

    }
}
