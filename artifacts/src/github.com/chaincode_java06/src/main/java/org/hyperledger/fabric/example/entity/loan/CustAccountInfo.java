package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class CustAccountInfo {

    private static final String OBJECT_TYPE_NAME = "CustAccountInfo";
    private String objectType = OBJECT_TYPE_NAME;

    public String tradeAccountId;

    public String custName;

    public String idNumber;

    public String bankCode;

    public String amount;

    public String balance;

    public Date updateDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getTradeAccountId() {
        return tradeAccountId;
    }

    public void setTradeAccountId(String tradeAccountId) {
        this.tradeAccountId = tradeAccountId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;
}
