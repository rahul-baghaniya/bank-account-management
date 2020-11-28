package com.cybrilla.bankaccountmanagement.model;

import java.util.List;

public class TransactionSummary {
    private CustomerDetails customerDetails;
    List<TransactionResponse> transactions;

    public TransactionSummary() {
    }

    public TransactionSummary(CustomerDetails customerDetails, List<TransactionResponse> transactions) {
        this.customerDetails = customerDetails;
        this.transactions = transactions;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<TransactionResponse> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionResponse> transactions) {
        this.transactions = transactions;
    }
}
