package org.hyperledger.fabric.example.entity.loan;


public class DetailAsset {
    private static final String OBJECT_TYPE_NAME = "DetailAsset";
    private String objectType = OBJECT_TYPE_NAME;

    private String loanNo;
    private String parentLoanNo;
    private String loanName;
    private String contractNo;
    private String contractAmount;
    private String loanType;
    private String contractCreditor;
    private String contractDebtor;
    private String interestStartDate;
    private String interestEndDate;
    private String loanTermType;
    private String actualPayDate;
    private String paymentType;
    private String loanMarginAmount;
    private String isThirdpartyWarranty;
    private String warrantyType;
    private String warrantorName;
    private String warrantorType;
    private String warrantorCreditLevel;
    private String warrantorAmount;
    private String updateDate;

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

    public String getParentLoanNo() {
        return parentLoanNo;
    }

    public void setParentLoanNo(String parentLoanNo) {
        this.parentLoanNo = parentLoanNo;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getContractCreditor() {
        return contractCreditor;
    }

    public void setContractCreditor(String contractCreditor) {
        this.contractCreditor = contractCreditor;
    }

    public String getContractDebtor() {
        return contractDebtor;
    }

    public void setContractDebtor(String contractDebtor) {
        this.contractDebtor = contractDebtor;
    }

    public String getInterestStartDate() {
        return interestStartDate;
    }

    public void setInterestStartDate(String interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public String getInterestEndDate() {
        return interestEndDate;
    }

    public void setInterestEndDate(String interestEndDate) {
        this.interestEndDate = interestEndDate;
    }

    public String getLoanTermType() {
        return loanTermType;
    }

    public void setLoanTermType(String loanTermType) {
        this.loanTermType = loanTermType;
    }

    public String getActualPayDate() {
        return actualPayDate;
    }

    public void setActualPayDate(String actualPayDate) {
        this.actualPayDate = actualPayDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getLoanMarginAmount() {
        return loanMarginAmount;
    }

    public void setLoanMarginAmount(String loanMarginAmount) {
        this.loanMarginAmount = loanMarginAmount;
    }

    public String getIsThirdpartyWarranty() {
        return isThirdpartyWarranty;
    }

    public void setIsThirdpartyWarranty(String isThirdpartyWarranty) {
        this.isThirdpartyWarranty = isThirdpartyWarranty;
    }

    public String getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(String warrantyType) {
        this.warrantyType = warrantyType;
    }

    public String getWarrantorName() {
        return warrantorName;
    }

    public void setWarrantorName(String warrantorName) {
        this.warrantorName = warrantorName;
    }

    public String getWarrantorType() {
        return warrantorType;
    }

    public void setWarrantorType(String warrantorType) {
        this.warrantorType = warrantorType;
    }

    public String getWarrantorCreditLevel() {
        return warrantorCreditLevel;
    }

    public void setWarrantorCreditLevel(String warrantorCreditLevel) {
        this.warrantorCreditLevel = warrantorCreditLevel;
    }

    public String getWarrantorAmount() {
        return warrantorAmount;
    }

    public void setWarrantorAmount(String warrantorAmount) {
        this.warrantorAmount = warrantorAmount;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
