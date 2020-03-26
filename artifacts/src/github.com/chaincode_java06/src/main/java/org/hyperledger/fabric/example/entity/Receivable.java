package org.hyperledger.fabric.example.entity;


import java.math.BigDecimal;
import java.util.Date;

public class Receivable {

    private static final String OBJECT_TYPE_NAME="receivable";

    private static final String objectType = OBJECT_TYPE_NAME;

    private String receivableRequestId;

    private String chainNo;

    private String blankNoteNo;

    private String blankNoteType;

    private String status;

    private String promisePayReviewStatus;

    private String platformReviewStatus;

    private String factorReviewStatus;

    private String loanEnterpriseReviewStatus;

    private BigDecimal amount;

    private BigDecimal remainAmount;

    private Date expireDate;

    private String issueEnterpriseName;

    private String issueEnterpriseId;

    private String commitmentPayEnterpriseName;

    private String commitmentPayEnterpriseId;

    private String isEnsure;

    private String ensureEnterpriseName;

    private String ensureEnterpriseId;

    private String financialOrgansName;

    private String financialOrgansId;

    private String holdEnterpriseName;

    private String holdEnterpriseId;

    private String lastBlankNoteNo;

    private String nextBlankNoteNo;

    private String isClear;

    private String remark3;

    private String remark2;

    private String remark;

    private Date createTime;

    private Date lastUpdateTime;

    private String addUserId;

    private String productCode;

    private String acceptEnterpriseName;

    private String acceptEnterpriseId;

    private String factorTransferStatus;

    private String counterpartyEnterpriseId;

    private String counterpartyEnterpriseName;

    private String platformFirstReviewor;

    private String platformSecondReviewor;

    private String factorFirstReviewor;

    private String factorSecondReviewor;

    private Date submitTime;

    public String getObjectType() {
        return objectType;
    }

    public String getReceivableRequestId() {
        return receivableRequestId;
    }

    public void setReceivableRequestId(String receivableRequestId) {
        this.receivableRequestId = receivableRequestId;
    }

    public String getChainNo() {
        return chainNo;
    }

    public void setChainNo(String chainNo) {
        this.chainNo = chainNo;
    }

    public String getBlankNoteNo() {
        return blankNoteNo;
    }

    public void setBlankNoteNo(String blankNoteNo) {
        this.blankNoteNo = blankNoteNo;
    }

    public String getBlankNoteType() {
        return blankNoteType;
    }

    public void setBlankNoteType(String blankNoteType) {
        this.blankNoteType = blankNoteType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPromisePayReviewStatus() {
        return promisePayReviewStatus;
    }

    public void setPromisePayReviewStatus(String promisePayReviewStatus) {
        this.promisePayReviewStatus = promisePayReviewStatus;
    }

    public String getPlatformReviewStatus() {
        return platformReviewStatus;
    }

    public void setPlatformReviewStatus(String platformReviewStatus) {
        this.platformReviewStatus = platformReviewStatus;
    }

    public String getFactorReviewStatus() {
        return factorReviewStatus;
    }

    public void setFactorReviewStatus(String factorReviewStatus) {
        this.factorReviewStatus = factorReviewStatus;
    }

    public String getLoanEnterpriseReviewStatus() {
        return loanEnterpriseReviewStatus;
    }

    public void setLoanEnterpriseReviewStatus(String loanEnterpriseReviewStatus) {
        this.loanEnterpriseReviewStatus = loanEnterpriseReviewStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getIssueEnterpriseName() {
        return issueEnterpriseName;
    }

    public void setIssueEnterpriseName(String issueEnterpriseName) {
        this.issueEnterpriseName = issueEnterpriseName;
    }

    public String getIssueEnterpriseId() {
        return issueEnterpriseId;
    }

    public void setIssueEnterpriseId(String issueEnterpriseId) {
        this.issueEnterpriseId = issueEnterpriseId;
    }

    public String getCommitmentPayEnterpriseName() {
        return commitmentPayEnterpriseName;
    }

    public void setCommitmentPayEnterpriseName(String commitmentPayEnterpriseName) {
        this.commitmentPayEnterpriseName = commitmentPayEnterpriseName;
    }

    public String getCommitmentPayEnterpriseId() {
        return commitmentPayEnterpriseId;
    }

    public void setCommitmentPayEnterpriseId(String commitmentPayEnterpriseId) {
        this.commitmentPayEnterpriseId = commitmentPayEnterpriseId;
    }

    public String getIsEnsure() {
        return isEnsure;
    }

    public void setIsEnsure(String isEnsure) {
        this.isEnsure = isEnsure;
    }

    public String getEnsureEnterpriseName() {
        return ensureEnterpriseName;
    }

    public void setEnsureEnterpriseName(String ensureEnterpriseName) {
        this.ensureEnterpriseName = ensureEnterpriseName;
    }

    public String getEnsureEnterpriseId() {
        return ensureEnterpriseId;
    }

    public void setEnsureEnterpriseId(String ensureEnterpriseId) {
        this.ensureEnterpriseId = ensureEnterpriseId;
    }

    public String getFinancialOrgansName() {
        return financialOrgansName;
    }

    public void setFinancialOrgansName(String financialOrgansName) {
        this.financialOrgansName = financialOrgansName;
    }

    public String getFinancialOrgansId() {
        return financialOrgansId;
    }

    public void setFinancialOrgansId(String financialOrgansId) {
        this.financialOrgansId = financialOrgansId;
    }

    public String getHoldEnterpriseName() {
        return holdEnterpriseName;
    }

    public void setHoldEnterpriseName(String holdEnterpriseName) {
        this.holdEnterpriseName = holdEnterpriseName;
    }

    public String getHoldEnterpriseId() {
        return holdEnterpriseId;
    }

    public void setHoldEnterpriseId(String holdEnterpriseId) {
        this.holdEnterpriseId = holdEnterpriseId;
    }

    public String getLastBlankNoteNo() {
        return lastBlankNoteNo;
    }

    public void setLastBlankNoteNo(String lastBlankNoteNo) {
        this.lastBlankNoteNo = lastBlankNoteNo;
    }

    public String getNextBlankNoteNo() {
        return nextBlankNoteNo;
    }

    public void setNextBlankNoteNo(String nextBlankNoteNo) {
        this.nextBlankNoteNo = nextBlankNoteNo;
    }

    public String getIsClear() {
        return isClear;
    }

    public void setIsClear(String isClear) {
        this.isClear = isClear;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAcceptEnterpriseName() {
        return acceptEnterpriseName;
    }

    public void setAcceptEnterpriseName(String acceptEnterpriseName) {
        this.acceptEnterpriseName = acceptEnterpriseName;
    }

    public String getAcceptEnterpriseId() {
        return acceptEnterpriseId;
    }

    public void setAcceptEnterpriseId(String acceptEnterpriseId) {
        this.acceptEnterpriseId = acceptEnterpriseId;
    }

    public String getFactorTransferStatus() {
        return factorTransferStatus;
    }

    public void setFactorTransferStatus(String factorTransferStatus) {
        this.factorTransferStatus = factorTransferStatus;
    }

    public String getCounterpartyEnterpriseId() {
        return counterpartyEnterpriseId;
    }

    public void setCounterpartyEnterpriseId(String counterpartyEnterpriseId) {
        this.counterpartyEnterpriseId = counterpartyEnterpriseId;
    }

    public String getCounterpartyEnterpriseName() {
        return counterpartyEnterpriseName;
    }

    public void setCounterpartyEnterpriseName(String counterpartyEnterpriseName) {
        this.counterpartyEnterpriseName = counterpartyEnterpriseName;
    }

    public String getPlatformFirstReviewor() {
        return platformFirstReviewor;
    }

    public void setPlatformFirstReviewor(String platformFirstReviewor) {
        this.platformFirstReviewor = platformFirstReviewor;
    }

    public String getPlatformSecondReviewor() {
        return platformSecondReviewor;
    }

    public void setPlatformSecondReviewor(String platformSecondReviewor) {
        this.platformSecondReviewor = platformSecondReviewor;
    }

    public String getFactorFirstReviewor() {
        return factorFirstReviewor;
    }

    public void setFactorFirstReviewor(String factorFirstReviewor) {
        this.factorFirstReviewor = factorFirstReviewor;
    }

    public String getFactorSecondReviewor() {
        return factorSecondReviewor;
    }

    public void setFactorSecondReviewor(String factorSecondReviewor) {
        this.factorSecondReviewor = factorSecondReviewor;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}
