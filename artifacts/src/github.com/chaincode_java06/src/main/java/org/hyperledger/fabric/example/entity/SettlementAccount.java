package org.hyperledger.fabric.example.entity;


import java.util.Date;

public class SettlementAccount {
    private static final String OBJECT_TYPE_NAME="enterprise_account";

    private static final String objectType = OBJECT_TYPE_NAME;

    private String bankAccountId;
    private String companyId;
    private String companyName;
    private String bankAccountNo;
    private String bankAccountName;

    private String bankName;

    private String bankBranchName;

    private String bankProvince;

    private String bankCity;

    private String bankCode;

    private String bankCnapsCode;

    private String bankUsage;
    private String status;

    private Date createTime;

    private Date lastUpdateTime;

    private String bankAccountCertificate;

    public String getObjectType() {
        return objectType;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCnapsCode() {
        return bankCnapsCode;
    }

    public void setBankCnapsCode(String bankCnapsCode) {
        this.bankCnapsCode = bankCnapsCode;
    }

    public String getBankUsage() {
        return bankUsage;
    }

    public void setBankUsage(String bankUsage) {
        this.bankUsage = bankUsage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getBankAccountCertificate() {
        return bankAccountCertificate;
    }

    public void setBankAccountCertificate(String bankAccountCertificate) {
        this.bankAccountCertificate = bankAccountCertificate;
    }
}