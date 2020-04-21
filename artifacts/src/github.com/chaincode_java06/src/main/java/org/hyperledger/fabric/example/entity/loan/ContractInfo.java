package org.hyperledger.fabric.example.entity.loan;


public class ContractInfo {

    private static final String OBJECT_TYPE_NAME = "ContractInfo";
    private String objectType = OBJECT_TYPE_NAME;

    private String belongTo;
    private String loanNo;
    private String name;
    private String contractNo;
    private String contractAmount;
    private String contractType;
    private String signingDate;
    private String startDate;
    private String endDate;
    private String buyerName;
    private String sellerName;
    private String isFinancinContract;
    private String receivableAmount;
    private String receivableTransferDate;
    private String receivablePaymentDate;
    private String collectionMethod;
    private String interestRate;
    private String otherPaymentMethod;
    private String otherInterestRate;
    private String isSignedByLegal;
    private String updateDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(String signingDate) {
        this.signingDate = signingDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getIsFinancinContract() {
        return isFinancinContract;
    }

    public void setIsFinancinContract(String isFinancinContract) {
        this.isFinancinContract = isFinancinContract;
    }

    public String getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(String receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public String getReceivableTransferDate() {
        return receivableTransferDate;
    }

    public void setReceivableTransferDate(String receivableTransferDate) {
        this.receivableTransferDate = receivableTransferDate;
    }

    public String getReceivablePaymentDate() {
        return receivablePaymentDate;
    }

    public void setReceivablePaymentDate(String receivablePaymentDate) {
        this.receivablePaymentDate = receivablePaymentDate;
    }

    public String getCollectionMethod() {
        return collectionMethod;
    }

    public void setCollectionMethod(String collectionMethod) {
        this.collectionMethod = collectionMethod;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getOtherPaymentMethod() {
        return otherPaymentMethod;
    }

    public void setOtherPaymentMethod(String otherPaymentMethod) {
        this.otherPaymentMethod = otherPaymentMethod;
    }

    public String getOtherInterestRate() {
        return otherInterestRate;
    }

    public void setOtherInterestRate(String otherInterestRate) {
        this.otherInterestRate = otherInterestRate;
    }

    public String getIsSignedByLegal() {
        return isSignedByLegal;
    }

    public void setIsSignedByLegal(String isSignedByLegal) {
        this.isSignedByLegal = isSignedByLegal;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
