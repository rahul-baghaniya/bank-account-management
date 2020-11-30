package com.cybrilla.bankaccountmanagement.controller;


import com.cybrilla.bankaccountmanagement.model.*;
import com.cybrilla.bankaccountmanagement.service.CustomerService;
import com.cybrilla.bankaccountmanagement.service.PayeeService;
import com.cybrilla.bankaccountmanagement.service.TransactionService;
import com.cybrilla.bankaccountmanagement.util.LogLevel;
import com.cybrilla.bankaccountmanagement.util.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/customerdashboard")
public class CustomerDashboardController {
    Logging logging = Logging.getLoggingInstance();

    @Autowired
    private PayeeService payeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/add/payee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payee> addPayee(@RequestBody AddPayeeDTO addPayeeDTO){
        logging.log(LogLevel.INFO,"CustomerDashboardController.addNewCustomer");
        return payeeService.addPayee(addPayeeDTO);
    }

    @GetMapping(value = "/view/balance/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> viewBalance(@PathVariable long customerId, String accountType){
        logging.log(LogLevel.INFO,"CustomerDashboardController.viewBalance");
        return customerService.viewBalance(customerId,accountType);
    }


    @PostMapping(value = "/transaction/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> makeTransaction(@RequestBody TransactionRequest transactionRequest, @PathVariable long accountId){
        logging.log(LogLevel.INFO,"CustomerDashboardController.makeTransaction");
        return transactionService.makeTransaction(transactionRequest,accountId);
    }


    @GetMapping(value = "/account/{accountId}/summary",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionSummary> viewAccountSummary(@PathVariable long accountId){
        logging.log(LogLevel.INFO,"CustomerDashboardController.viewAccountSummary");
        return transactionService.viewAccountSummary(accountId);
    }
}