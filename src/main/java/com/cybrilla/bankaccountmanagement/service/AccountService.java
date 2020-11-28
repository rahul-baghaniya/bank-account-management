package com.cybrilla.bankaccountmanagement.service;

import com.cybrilla.bankaccountmanagement.model.Account;
import com.cybrilla.bankaccountmanagement.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
@Autowired
    private AccountRepo accountRepo;

    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountRepo.findAll();
        return  new ResponseEntity<>(accounts, HttpStatus.FOUND);
    }


  /*  public ResponseEntity<Account> findAccount (long accountNumber) {
         Account result = accountRepo.findByAccountNumber(accountNumber).get();
         return new ResponseEntity<>(result, HttpStatus.FOUND);
    }*/
}
