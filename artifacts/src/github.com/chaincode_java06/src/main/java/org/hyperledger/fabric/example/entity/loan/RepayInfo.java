package org.hyperledger.fabric.example.entity.loan;


import java.util.Date;

public class RepayInfo {

    private static final String OBJECT_TYPE_NAME = "RepayInfo";
    private String objectType = OBJECT_TYPE_NAME;

    public String loanNo;
    public String currentIssue;

    public String currentIssueStatus;
    public Date payDate;
    public String principalPaid;
    public String interestPaid;

    public String securityChargePaid;
    public String serviceChargePaid;
    public String chargeMoneyPaid;
    public String otherPaymentPaid;
    public String overdueAmount;
    public String overdueArrears;
    public Date substitutionPaymentDate;
    public String substitutionPaymentAmount;
    public String continuousTimesOverdue;
    public String accumulateOverdueTimes;
    public String substitutePaymentTimes;
    public String duePenaltyTotalAmount;
    public String paidPenaltyTotalAmount;
    public String surplusPenaltyAmount;
    public String deductionMarginAmount;
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

    public String getCurrentIssue() {
        return currentIssue;
    }

    public void setCurrentIssue(String currentIssue) {
        this.currentIssue = currentIssue;
    }

    public String getCurrentIssueStatus() {
        return currentIssueStatus;
    }

    public void setCurrentIssueStatus(String currentIssueStatus) {
        this.currentIssueStatus = currentIssueStatus;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(String principalPaid) {
        this.principalPaid = principalPaid;
    }

    public String getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(String interestPaid) {
        this.interestPaid = interestPaid;
    }

    public String getSecurityChargePaid() {
        return securityChargePaid;
    }

    public void setSecurityChargePaid(String securityChargePaid) {
        this.securityChargePaid = securityChargePaid;
    }

    public String getServiceChargePaid() {
        return serviceChargePaid;
    }

    public void setServiceChargePaid(String serviceChargePaid) {
        this.serviceChargePaid = serviceChargePaid;
    }

    public String getChargeMoneyPaid() {
        return chargeMoneyPaid;
    }

    public void setChargeMoneyPaid(String chargeMoneyPaid) {
        this.chargeMoneyPaid = chargeMoneyPaid;
    }

    public String getOtherPaymentPaid() {
        return otherPaymentPaid;
    }

    public void setOtherPaymentPaid(String otherPaymentPaid) {
        this.otherPaymentPaid = otherPaymentPaid;
    }

    public String getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(String overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public String getOverdueArrears() {
        return overdueArrears;
    }

    public void setOverdueArrears(String overdueArrears) {
        this.overdueArrears = overdueArrears;
    }

    public Date getSubstitutionPaymentDate() {
        return substitutionPaymentDate;
    }

    public void setSubstitutionPaymentDate(Date substitutionPaymentDate) {
        this.substitutionPaymentDate = substitutionPaymentDate;
    }

    public String getSubstitutionPaymentAmount() {
        return substitutionPaymentAmount;
    }

    public void setSubstitutionPaymentAmount(String substitutionPaymentAmount) {
        this.substitutionPaymentAmount = substitutionPaymentAmount;
    }

    public String getContinuousTimesOverdue() {
        return continuousTimesOverdue;
    }

    public void setContinuousTimesOverdue(String continuousTimesOverdue) {
        this.continuousTimesOverdue = continuousTimesOverdue;
    }

    public String getAccumulateOverdueTimes() {
        return accumulateOverdueTimes;
    }

    public void setAccumulateOverdueTimes(String accumulateOverdueTimes) {
        this.accumulateOverdueTimes = accumulateOverdueTimes;
    }

    public String getSubstitutePaymentTimes() {
        return substitutePaymentTimes;
    }

    public void setSubstitutePaymentTimes(String substitutePaymentTimes) {
        this.substitutePaymentTimes = substitutePaymentTimes;
    }

    public String getDuePenaltyTotalAmount() {
        return duePenaltyTotalAmount;
    }

    public void setDuePenaltyTotalAmount(String duePenaltyTotalAmount) {
        this.duePenaltyTotalAmount = duePenaltyTotalAmount;
    }

    public String getPaidPenaltyTotalAmount() {
        return paidPenaltyTotalAmount;
    }

    public void setPaidPenaltyTotalAmount(String paidPenaltyTotalAmount) {
        this.paidPenaltyTotalAmount = paidPenaltyTotalAmount;
    }

    public String getSurplusPenaltyAmount() {
        return surplusPenaltyAmount;
    }

    public void setSurplusPenaltyAmount(String surplusPenaltyAmount) {
        this.surplusPenaltyAmount = surplusPenaltyAmount;
    }

    public String getDeductionMarginAmount() {
        return deductionMarginAmount;
    }

    public void setDeductionMarginAmount(String deductionMarginAmount) {
        this.deductionMarginAmount = deductionMarginAmount;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
