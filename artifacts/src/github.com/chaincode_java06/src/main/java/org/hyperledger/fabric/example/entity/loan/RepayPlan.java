package org.hyperledger.fabric.example.entity.loan;

import java.util.Date;

public class RepayPlan {

    private static final String OBJECT_TYPE_NAME = "RepayPlan";
    private String objectType = OBJECT_TYPE_NAME;
    public String loanNo;
    public String issue;
    public Date dueDate;
    public String principalDue;
    public String interestDue;
    public String securityChargeDue;
    public String serviceChargeDue;
    public String chargeMoneyDue;
    public String otherPaymentDue;
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

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPrincipalDue() {
        return principalDue;
    }

    public void setPrincipalDue(String principalDue) {
        this.principalDue = principalDue;
    }

    public String getInterestDue() {
        return interestDue;
    }

    public void setInterestDue(String interestDue) {
        this.interestDue = interestDue;
    }

    public String getSecurityChargeDue() {
        return securityChargeDue;
    }

    public void setSecurityChargeDue(String securityChargeDue) {
        this.securityChargeDue = securityChargeDue;
    }

    public String getServiceChargeDue() {
        return serviceChargeDue;
    }

    public void setServiceChargeDue(String serviceChargeDue) {
        this.serviceChargeDue = serviceChargeDue;
    }

    public String getChargeMoneyDue() {
        return chargeMoneyDue;
    }

    public void setChargeMoneyDue(String chargeMoneyDue) {
        this.chargeMoneyDue = chargeMoneyDue;
    }

    public String getOtherPaymentDue() {
        return otherPaymentDue;
    }

    public void setOtherPaymentDue(String otherPaymentDue) {
        this.otherPaymentDue = otherPaymentDue;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
