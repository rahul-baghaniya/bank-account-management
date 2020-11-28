package com.cybrilla.bankaccountmanagement.model;

import java.math.BigDecimal;

public class TransactionRequest {

    private BigDecimal amount;
    private String transactionType;
    private String description;

    public TransactionRequest() {
    }

    public TransactionRequest(BigDecimal amount, String transactionType, String description) {

        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
    }



    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
