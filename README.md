# bank-account-management

**run sql queries for test data**

         under src/resources/data.sql folder
     

swagger url to test the apis: 
   
      http://localhost:8080/api/swagger-ui.html#  

**Customer:**

     manage fund: /customerdashboard/transaction/{accountId}
     manage payee: /customerdashboard/add/payee
     view balance: /customerdashboard/view/balance/{customerId}
     account summary: /customerdashboard/account/{accountId}/summary
   
**Bank Employee:

       add new account:** 
              addNewCustomer:  /employeedashboard/add/customer/
              addAccountForCustomer: /employeedashboard/add/account/
      manage customer status:
              /employeedashboard/update/account/status/{accountId}
              
