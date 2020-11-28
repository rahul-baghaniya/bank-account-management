package com.cybrilla.bankaccountmanagement.controller;


import com.cybrilla.bankaccountmanagement.model.Account;
import com.cybrilla.bankaccountmanagement.model.Customer;
import com.cybrilla.bankaccountmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeedashboard")
public class BankEmpDashboardController {

  @Autowired
  private CustomerService customerService;


   // public void addNewAccount(){}


    @PostMapping(value = "/add/customer/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addNewCustomer(@Validated  @RequestBody Customer customer){
        return customerService.addNewCustomer(customer);
    }


    @PostMapping(value = "/add/account/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> addAccountForCustomer(@Validated  @RequestBody Account account){
        return customerService.addAccountForCustomer(account);
    }

    public void manageCustomerAccount(){}

   // public void manageCustomerStatus(){}
   @PutMapping(value = "/update/account/status/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Account> manageCustomerStatus(@PathVariable long accountId, String newAccountStatus){
     return customerService.manageCustomerStatus(accountId,newAccountStatus);
   }

   @GetMapping(value = "/view/customer/{accountId}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Account> viewCustomerAccount(@PathVariable long accountId){
      return customerService.viewCustomerAccount(accountId);
   }

  @GetMapping(value = "customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Account>> getAccounts(){
    return customerService.getAccounts();
  }
}
