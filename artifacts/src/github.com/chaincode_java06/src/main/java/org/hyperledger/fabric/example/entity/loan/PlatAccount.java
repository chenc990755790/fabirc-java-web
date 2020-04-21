package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class PlatAccount {

    private static final String OBJECT_TYPE_NAME = "PlatAccount";
    private String objectType = OBJECT_TYPE_NAME;

    public String tradeAccountId;

    public String tradeType;

    public Date tradeDate;

    public Date tradeTime;

    public String amount;

    public Date updateDate;

    public String id;

    public String tradeStatus;

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

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
}
