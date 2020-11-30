package com.cybrilla.bankaccountmanagement.controller;

import com.cybrilla.bankaccountmanagement.BankAccountManagementApplication;
import com.cybrilla.bankaccountmanagement.model.AddPayeeDTO;
import com.cybrilla.bankaccountmanagement.model.Payee;
import com.cybrilla.bankaccountmanagement.service.CustomerService;
import com.cybrilla.bankaccountmanagement.service.PayeeService;
import com.cybrilla.bankaccountmanagement.service.TransactionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BankAccountManagementApplication.class)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")
})
public class CustomerDashboardE2ETest {
    @InjectMocks
    private CustomerDashboardController customerController;


    @Mock
    private PayeeService payeeService;

    @Mock
    private CustomerService customerService;

    @Mock
    private TransactionService transactionService;


    @Test
    public void testAddPayee(){
        AddPayeeDTO addPayeeDTO = new AddPayeeDTO(1,1234567890,"rahul");

        ResponseEntity<Payee> payeeResponseEntity =  customerController.addPayee(addPayeeDTO);

        Assert.assertEquals(1,payeeResponseEntity.getBody().getId());
        Assert.assertEquals(1234567890,payeeResponseEntity.getBody().getPayeeAccountId());
    }



}