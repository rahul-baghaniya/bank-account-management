package com.cybrilla.bankaccountmanagement.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionResponse {
    private BigDecimal amount;
    private BigDecimal balance;
    private String transactionType;
    private String description;
    private Date date;

    public TransactionResponse() {
    }

    public TransactionResponse(BigDecimal amount, BigDecimal balance, String transactionType,
                               String description, Date date) {
        this.amount = amount;
        this.balance = balance;
        this.transactionType = transactionType;
        this.description = description;
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
