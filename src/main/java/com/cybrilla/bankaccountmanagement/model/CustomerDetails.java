package com.cybrilla.bankaccountmanagement.model;

import java.math.BigDecimal;

public class CustomerDetails {
    private String name;
    private String lastName;
    private String email;
    private long accountId;
    private AccountType accountType;
    private BigDecimal balance;


    public CustomerDetails() {
    }


    public CustomerDetails(String name, String lastName, String email, long accountId,
                           AccountType accountType, BigDecimal balance) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
