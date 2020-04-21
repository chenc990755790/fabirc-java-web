package org.hyperledger.fabric.example.entity.loan;


public class CustInfo {
    private static final String OBJECT_TYPE_NAME = "CustInfo";
    private String objectType = OBJECT_TYPE_NAME;
    private String prodNo;
    private String tradeAccountId;
    private String serialNumber;
    private String prodName;
    private String custName;
    private String custTypeCode;
    private String requestTime;
    private String payAmount;
    private String payDate;
    private String amount;
    private String assignPromise;
    private String riskRank;
    private String whitelist;
    private String superwhitelist;
    private String bankAccNo;
    private String updateDate;

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

    public String getTradeAccountId() {
        return tradeAccountId;
    }

    public void setTradeAccountId(String tradeAccountId) {
        this.tradeAccountId = tradeAccountId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustTypeCode() {
        return custTypeCode;
    }

    public void setCustTypeCode(String custTypeCode) {
        this.custTypeCode = custTypeCode;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAssignPromise() {
        return assignPromise;
    }

    public void setAssignPromise(String assignPromise) {
        this.assignPromise = assignPromise;
    }

    public String getRiskRank() {
        return riskRank;
    }

    public void setRiskRank(String riskRank) {
        this.riskRank = riskRank;
    }

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist;
    }

    public String getSuperwhitelist() {
        return superwhitelist;
    }

    public void setSuperwhitelist(String superwhitelist) {
        this.superwhitelist = superwhitelist;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
