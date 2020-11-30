package com.cybrilla.bankaccountmanagement.controller;


import com.cybrilla.bankaccountmanagement.model.Account;
import com.cybrilla.bankaccountmanagement.model.Customer;
import com.cybrilla.bankaccountmanagement.service.CustomerService;
import com.cybrilla.bankaccountmanagement.util.LogLevel;
import com.cybrilla.bankaccountmanagement.util.Logging;
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

    Logging logging = Logging.getLoggingInstance();

    @PostMapping(value = "/add/customer/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addNewCustomer(@Validated  @RequestBody Customer customer){
        logging.log(LogLevel.INFO,"BankEmpDashboardController.addNewCustomer");
        return customerService.addNewCustomer(customer);
    }


    @PostMapping(value = "/add/account/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> addAccountForCustomer(@Validated  @RequestBody Account account){
        logging.log(LogLevel.INFO,"BankEmpDashboardController.addAccountForCustomer");
        return customerService.addAccountForCustomer(account);
    }


   // public void manageCustomerStatus(){}
   @PutMapping(value = "/update/account/status/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Account> manageCustomerStatus(@PathVariable long accountId, String newAccountStatus){
       logging.log(LogLevel.INFO,"BankEmpDashboardController.manageCustomerStatus");
     return customerService.manageCustomerStatus(accountId,newAccountStatus);
   }

   @GetMapping(value = "/view/customer/{accountId}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Account> viewCustomerAccount(@PathVariable long accountId){
      return customerService.viewCustomerAccount(accountId);
   }

  @GetMapping(value = "customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Account>> getAccounts(){
      logging.log(LogLevel.INFO,"BankEmpDashboardController.getAccounts");
    return customerService.getAccounts();
  }

    @GetMapping(value = "/customers/{customerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findCustomerByName(@PathVariable String customerName){
        logging.log(LogLevel.INFO,"BankEmpDashboardController.findCustomerByName");
        return customerService.findCustomerByName(customerName);

    }
}
