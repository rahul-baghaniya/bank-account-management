package com.cybrilla.bankaccountmanagement.service;

import com.cybrilla.bankaccountmanagement.BankAccountManagementApplication;
import com.cybrilla.bankaccountmanagement.model.AddPayeeDTO;
import com.cybrilla.bankaccountmanagement.model.Payee;
import com.cybrilla.bankaccountmanagement.repository.AccountRepo;
import com.cybrilla.bankaccountmanagement.repository.CustomerRepo;
import com.cybrilla.bankaccountmanagement.repository.PayeeRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BankAccountManagementApplication.class)
//@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
//        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")
//})
public class PayeeServiceE2ETest {
    @InjectMocks
    private PayeeService payeeService;

    @Mock
    private PayeeRepo payeeRepo;


    @Mock
    private AccountRepo accountRepo;


    @Mock
    private CustomerRepo customerRepo;
    @Test
    public void testAddPayee(){
        AddPayeeDTO addPayeeDTO = new AddPayeeDTO(1123456,2222,"rahul1");

        ResponseEntity<Payee> payeeResponseEntity =  payeeService.addPayee(addPayeeDTO);

        Assert.assertEquals(105,payeeResponseEntity.getBody().getId());
        //Assert.assertEquals(1234567890,payeeResponseEntity.getBody().getPayeeAccountId());
    }

}