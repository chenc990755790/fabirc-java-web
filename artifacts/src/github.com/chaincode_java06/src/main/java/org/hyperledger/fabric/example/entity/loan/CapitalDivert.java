package org.hyperledger.fabric.example.entity.loan;


public class CapitalDivert {
    private static final String OBJECT_TYPE_NAME = "CapitalDivert";
    private String objectType = OBJECT_TYPE_NAME;
    private String capitalDivertId;
    private String divertType;
    private String capitalChannelId;
    private String amount;
    private String status;
    private String requestTime;
    private String bankCode;
    private String bankAccountName;
    private String bankAccountNo;
    private String bankBranch;
    private String bankBranchCode;
    private String createTime;
    private String lastUpdateTime;
    private String dataDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getCapitalDivertId() {
        return capitalDivertId;
    }

    public void setCapitalDivertId(String capitalDivertId) {
        this.capitalDivertId = capitalDivertId;
    }

    public String getDivertType() {
        return divertType;
    }

    public void setDivertType(String divertType) {
        this.divertType = divertType;
    }

    public String getCapitalChannelId() {
        return capitalChannelId;
    }

    public void setCapitalChannelId(String capitalChannelId) {
        this.capitalChannelId = capitalChannelId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }
}
