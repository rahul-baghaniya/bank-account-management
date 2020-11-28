/*
package com.cybrilla.bankaccountmanagement.controller;


import com.cybrilla.bankaccountmanagement.model.Account;
import com.cybrilla.bankaccountmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping(value = "/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findAccount(@PathVariable long accountNumber){
        return accountService.findAccount(accountNumber);

    }
}
*/
