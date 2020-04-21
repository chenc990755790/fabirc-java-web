package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class SelfProdChange {

    private static final String OBJECT_TYPE_NAME = "SelfProdChange";
    private String objectType = OBJECT_TYPE_NAME;

    public String prodNo;

    public String reqType;
    public String reqTime;

    public Date updateDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
