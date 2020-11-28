package com.cybrilla.bankaccountmanagement.model;

public class AddPayeeDTO {
    private long customerId;
    private long payeeAccountId;
    private String payeeName;

    public AddPayeeDTO() {
    }

    public AddPayeeDTO(long customerId, long payeeAccountId, String payeeName) {
        this.customerId = customerId;
        this.payeeAccountId = payeeAccountId;
        this.payeeName = payeeName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }



    public long getPayeeAccountId() {
        return payeeAccountId;
    }

    public void setPayeeAccountId(long payeeAccountId) {
        this.payeeAccountId = payeeAccountId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }
}
