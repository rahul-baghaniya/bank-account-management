package com.cybrilla.bankaccountmanagement.controller;


import com.cybrilla.bankaccountmanagement.model.Customer;
import com.cybrilla.bankaccountmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public void manaeFund(){ }
    public void managePayee(){}
    public void getBalance(){}
    public void getAccountsummary(){}

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addNewCustomer(@Validated  @RequestBody Customer customer){
           return customerService.addNewCustomer(customer);
    }

    @GetMapping(value = "/{customerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findCustomerByName(@PathVariable String customerName){
        return customerService.findCustomerByName(customerName);

    }
}
