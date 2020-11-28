package com.cybrilla.bankaccountmanagement.controller;


import com.cybrilla.bankaccountmanagement.model.*;
import com.cybrilla.bankaccountmanagement.service.CustomerService;
import com.cybrilla.bankaccountmanagement.service.PayeeService;
import com.cybrilla.bankaccountmanagement.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(CustomerDashboardController.class)
public class CustomerDashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PayeeService payeeService;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private TransactionService transactionService;




    @Test
    public void testViewAccountSummary() throws Exception {
        long accountId = 1;
        TransactionSummary transactionSummary = new TransactionSummary();
        CustomerDetails customerDetails = new CustomerDetails("rahul","baghaniya","rahul@gmail.com",
                                                1,AccountType.SAVINGS,BigDecimal.valueOf(500));

        List<TransactionResponse> transactionResponseList = new ArrayList<>();
        TransactionResponse transactionResponse = new TransactionResponse(BigDecimal.valueOf(100),
                BigDecimal.valueOf(300),TransactionType.DEBIT.name(),"gift",null);
        transactionResponseList.add(transactionResponse);

        transactionSummary.setCustomerDetails(customerDetails);
        transactionSummary.setTransactions(transactionResponseList);

        ObjectMapper mapper = new ObjectMapper();
        String expectedOutput = mapper.writeValueAsString(transactionSummary);

        Mockito.when(transactionService.viewAccountSummary(accountId))
                .thenReturn(ResponseEntity.of(Optional.of(transactionSummary)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/customerdashboard/account/{accountId}/summary",accountId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(request).andReturn();
        String response  = result.getResponse().getContentAsString();
        assertEquals(expectedOutput,response);

    }

    @Test
    public void testViewBalance() throws Exception {
        long customerId = 1;
        Mockito.when(customerService.viewBalance(Mockito.anyLong(),Mockito.anyString()))
                .thenReturn(ResponseEntity.of(Optional.of(BigDecimal.valueOf(500))));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/customerdashboard/view/balance/{customerId}",customerId)
                .param("accountType","SAVINGS")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        String response  = result.getResponse().getContentAsString();
        assertEquals("500",response);
    }

    @Test
    public void testAddPayee() throws Exception {
        Customer customer = new Customer(1,"anjali","kumari",
                "anjali@gmail.com",null);
        Payee payee = new Payee(1,"rahul",1234567890,customer);

        AddPayeeDTO addPayeeDTO = new AddPayeeDTO(1,1234567890,"rahul");

        Mockito.when(payeeService.addPayee(Mockito.any(addPayeeDTO.getClass()))).thenReturn(ResponseEntity.of(Optional.of(payee)));
        ObjectMapper mapper = new ObjectMapper();
        String inputRequest = mapper.writeValueAsString(addPayeeDTO);
        String expectedOutput = mapper.writeValueAsString(payee);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/customerdashboard/add/payee")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputRequest)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        String response  = result.getResponse().getContentAsString();
        assertEquals(expectedOutput,response);
    }
}