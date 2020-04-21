package org.hyperledger.fabric.example.entity.loan;

import java.util.Date;

public class CapitalNotice {

    private static final String OBJECT_TYPE_NAME = "CapitalNotice";
    private String objectType = OBJECT_TYPE_NAME;

    public String capitalNoticeId;
    public String capitalChannelId;
    public String amount;
    public String dealStatus;
    public Date responseTime;
    public String responseWorkday;
    public String bankAccountName;
    public String bankAccountNo;
    public String channelOrderNo;
    public String noticeOrderNo;
    public String bankBranchCode;
    public String bankBranch;
    public String capitalReqId;
    public Date createTime;
    public Date lastUpdateTtime;
    public Date dataDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getCapitalNoticeId() {
        return capitalNoticeId;
    }

    public void setCapitalNoticeId(String capitalNoticeId) {
        this.capitalNoticeId = capitalNoticeId;
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

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseWorkday() {
        return responseWorkday;
    }

    public void setResponseWorkday(String responseWorkday) {
        this.responseWorkday = responseWorkday;
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

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public String getNoticeOrderNo() {
        return noticeOrderNo;
    }

    public void setNoticeOrderNo(String noticeOrderNo) {
        this.noticeOrderNo = noticeOrderNo;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getCapitalReqId() {
        return capitalReqId;
    }

    public void setCapitalReqId(String capitalReqId) {
        this.capitalReqId = capitalReqId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTtime() {
        return lastUpdateTtime;
    }

    public void setLastUpdateTtime(Date lastUpdateTtime) {
        this.lastUpdateTtime = lastUpdateTtime;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }
}
