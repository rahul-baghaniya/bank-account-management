# bank-account-management

**Problem statement:**





![Screenshot (66)](https://user-images.githubusercontent.com/19568537/135663166-5c8bf66a-afc1-4d0b-98b3-d6462d53e15c.png)


![Screenshot (67)](https://user-images.githubusercontent.com/19568537/135663185-9093cd07-99d2-4c87-9c0d-cddb558ec782.png)

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
              
