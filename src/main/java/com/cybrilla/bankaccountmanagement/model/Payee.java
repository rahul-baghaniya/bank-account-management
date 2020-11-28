package com.cybrilla.bankaccountmanagement.model;


import javax.persistence.*;

@Entity
@Table(name = "payee")
public class Payee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String payeeName;

    private long payeeAccountId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Payee() {
    }

    public Payee(long id, String payeeName, long payeeAccountId, Customer customer) {
        this.id = id;
        this.payeeName = payeeName;
        this.payeeAccountId = payeeAccountId;
        this.customer = customer;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPayeeAccountId() {
        return payeeAccountId;
    }

    public void setPayeeAccountId(long payeeAccountId) {
        this.payeeAccountId = payeeAccountId;
    }
}
