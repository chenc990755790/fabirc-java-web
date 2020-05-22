package org.hyperledger.fabric.example.entity.factoring;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AssetTransfer {

    public static final String OBJECT_TYPE_NAME = "assetTransfer";
    private String objectType = OBJECT_TYPE_NAME;

    private String assetPackageReqId;

    private Date createTime;

    private Date lastUpdateTime;

    private String status;
    private String statusText;

    private String transferType;
    private String transferStatus;
    private String transferStatusText;

    private String channelSocialCreditCode;
    private String channelCompanyName;

    private String factoringSocialCreditCode;
    private String factoringCompanyName;

    private String fundingSocialCreditCode;
    private String fundingCompanyName;

    private String financingAccountName;
    private String openBankBranchName;
    private String financingAccountNo;

    private String transferContractNo;
    private String transferContractReceiptNo;

    private BigDecimal totalAmount;
    private BigDecimal totalInvoiceAmount;

    private String operatorId;

    private String operatorName;

    private String reviewComment;

    private String operationType;

    private List<AssetNotices> assetNoticesList;

    public String getObjectType() {
        return objectType;
    }

    public String getAssetPackageReqId() {
        return assetPackageReqId;
    }

    public void setAssetPackageReqId(String assetPackageReqId) {
        this.assetPackageReqId = assetPackageReqId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferStatusText() {
        return transferStatusText;
    }

    public void setTransferStatusText(String transferStatusText) {
        this.transferStatusText = transferStatusText;
    }

    public String getChannelSocialCreditCode() {
        return channelSocialCreditCode;
    }

    public void setChannelSocialCreditCode(String channelSocialCreditCode) {
        this.channelSocialCreditCode = channelSocialCreditCode;
    }

    public String getChannelCompanyName() {
        return channelCompanyName;
    }

    public void setChannelCompanyName(String channelCompanyName) {
        this.channelCompanyName = channelCompanyName;
    }

    public String getFactoringSocialCreditCode() {
        return factoringSocialCreditCode;
    }

    public void setFactoringSocialCreditCode(String factoringSocialCreditCode) {
        this.factoringSocialCreditCode = factoringSocialCreditCode;
    }

    public String getFactoringCompanyName() {
        return factoringCompanyName;
    }

    public void setFactoringCompanyName(String factoringCompanyName) {
        this.factoringCompanyName = factoringCompanyName;
    }

    public String getFundingSocialCreditCode() {
        return fundingSocialCreditCode;
    }

    public void setFundingSocialCreditCode(String fundingSocialCreditCode) {
        this.fundingSocialCreditCode = fundingSocialCreditCode;
    }

    public String getFundingCompanyName() {
        return fundingCompanyName;
    }

    public void setFundingCompanyName(String fundingCompanyName) {
        this.fundingCompanyName = fundingCompanyName;
    }

    public String getFinancingAccountName() {
        return financingAccountName;
    }

    public void setFinancingAccountName(String financingAccountName) {
        this.financingAccountName = financingAccountName;
    }

    public String getOpenBankBranchName() {
        return openBankBranchName;
    }

    public void setOpenBankBranchName(String openBankBranchName) {
        this.openBankBranchName = openBankBranchName;
    }

    public String getFinancingAccountNo() {
        return financingAccountNo;
    }

    public void setFinancingAccountNo(String financingAccountNo) {
        this.financingAccountNo = financingAccountNo;
    }

    public String getTransferContractNo() {
        return transferContractNo;
    }

    public void setTransferContractNo(String transferContractNo) {
        this.transferContractNo = transferContractNo;
    }

    public String getTransferContractReceiptNo() {
        return transferContractReceiptNo;
    }

    public void setTransferContractReceiptNo(String transferContractReceiptNo) {
        this.transferContractReceiptNo = transferContractReceiptNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalInvoiceAmount() {
        return totalInvoiceAmount;
    }

    public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
        this.totalInvoiceAmount = totalInvoiceAmount;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public List<AssetNotices> getAssetNoticesList() {
        return assetNoticesList;
    }

    public void setAssetNoticesList(List<AssetNotices> assetNoticesList) {
        this.assetNoticesList = assetNoticesList;
    }
}
