package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class BillInfo {

    private static final String OBJECT_TYPE_NAME = "BillInfo";
    private String objectType = OBJECT_TYPE_NAME;
    public String loanNo;
    public String invoiceNo;
    public String invoiceCode;
    public String passedAfterInspection;
    public String whetherIsInvalid;
    public String whetherRegisterZhongdeng;
    public Date invoiceDate;
    public String invoiceHasTaxAmount;
    public Date updateDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getPassedAfterInspection() {
        return passedAfterInspection;
    }

    public void setPassedAfterInspection(String passedAfterInspection) {
        this.passedAfterInspection = passedAfterInspection;
    }

    public String getWhetherIsInvalid() {
        return whetherIsInvalid;
    }

    public void setWhetherIsInvalid(String whetherIsInvalid) {
        this.whetherIsInvalid = whetherIsInvalid;
    }

    public String getWhetherRegisterZhongdeng() {
        return whetherRegisterZhongdeng;
    }

    public void setWhetherRegisterZhongdeng(String whetherRegisterZhongdeng) {
        this.whetherRegisterZhongdeng = whetherRegisterZhongdeng;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceHasTaxAmount() {
        return invoiceHasTaxAmount;
    }

    public void setInvoiceHasTaxAmount(String invoiceHasTaxAmount) {
        this.invoiceHasTaxAmount = invoiceHasTaxAmount;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
