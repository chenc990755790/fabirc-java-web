package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class SelfProdPayment {

    private static final String OBJECT_TYPE_NAME = "SelfProdPayment";
    private String objectType = OBJECT_TYPE_NAME;

    public String productPaymentId;

    public String prodNo;
    public String volume;
    public String actualInterest;

    public Date payBackTime;

    public Date updateDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getProductPaymentId() {
        return productPaymentId;
    }

    public void setProductPaymentId(String productPaymentId) {
        this.productPaymentId = productPaymentId;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getActualInterest() {
        return actualInterest;
    }

    public void setActualInterest(String actualInterest) {
        this.actualInterest = actualInterest;
    }

    public Date getPayBackTime() {
        return payBackTime;
    }

    public void setPayBackTime(Date payBackTime) {
        this.payBackTime = payBackTime;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
