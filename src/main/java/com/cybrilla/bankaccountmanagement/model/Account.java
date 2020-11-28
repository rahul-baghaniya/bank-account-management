package com.cybrilla.bankaccountmanagement.model;


import javax.persistence.*;
import java.math.BigDecimal;

import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private BigDecimal balance;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account() {
    }

    public Account(long id, AccountType accountType, BigDecimal balance, AccountStatus status, Date date, Customer customer) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.date = date;
        this.customer = customer;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
