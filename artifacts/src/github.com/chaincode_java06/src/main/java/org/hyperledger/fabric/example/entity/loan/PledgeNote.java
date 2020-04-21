package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class PledgeNote {

    private static final String OBJECT_TYPE_NAME = "PledgeNote";
    private String objectType = OBJECT_TYPE_NAME;

    public String loanLevelText;
    public String loanNo;

    public String pledgedBillNumber;
    public String collertalModel;
    public String billType;

    public String billAmount;
    public Date issueDate;
    public Date expiryDate;
    public String drawerName;
    public String billAcceptor;
    public Date updateDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getLoanLevelText() {
        return loanLevelText;
    }

    public void setLoanLevelText(String loanLevelText) {
        this.loanLevelText = loanLevelText;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getPledgedBillNumber() {
        return pledgedBillNumber;
    }

    public void setPledgedBillNumber(String pledgedBillNumber) {
        this.pledgedBillNumber = pledgedBillNumber;
    }

    public String getCollertalModel() {
        return collertalModel;
    }

    public void setCollertalModel(String collertalModel) {
        this.collertalModel = collertalModel;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDrawerName() {
        return drawerName;
    }

    public void setDrawerName(String drawerName) {
        this.drawerName = drawerName;
    }

    public String getBillAcceptor() {
        return billAcceptor;
    }

    public void setBillAcceptor(String billAcceptor) {
        this.billAcceptor = billAcceptor;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
