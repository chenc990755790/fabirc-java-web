package org.hyperledger.fabric.example.entity.loan;

import java.util.Date;

public class ProductInfo {

    private static final String OBJECT_TYPE_NAME = "ProductInfo";
    private String objectType = OBJECT_TYPE_NAME;

    public String assetPackageId;
    public String prodId;
    public String prodName;
    public String hangVolume;
    public Date hangDate;
    public String tradeMode;
    public String singleSubscribeMin;
    public Date startRaiseTime;
    public Date endRaiseTime;
    public String statusCode;
    public String investorMax;
    public Date expectStartInterestDate;
    public Date expectEndInterestDate;
    public Date expectDuration;
    public String riskLevel;
    public String benefitRate;
    public String annualizedRate;
    public String isPayment;
    public String summay;
    public Date payDate;
    public Date updateDate;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getAssetPackageId() {
        return assetPackageId;
    }

    public void setAssetPackageId(String assetPackageId) {
        this.assetPackageId = assetPackageId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getHangVolume() {
        return hangVolume;
    }

    public void setHangVolume(String hangVolume) {
        this.hangVolume = hangVolume;
    }

    public Date getHangDate() {
        return hangDate;
    }

    public void setHangDate(Date hangDate) {
        this.hangDate = hangDate;
    }

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode;
    }

    public String getSingleSubscribeMin() {
        return singleSubscribeMin;
    }

    public void setSingleSubscribeMin(String singleSubscribeMin) {
        this.singleSubscribeMin = singleSubscribeMin;
    }

    public Date getStartRaiseTime() {
        return startRaiseTime;
    }

    public void setStartRaiseTime(Date startRaiseTime) {
        this.startRaiseTime = startRaiseTime;
    }

    public Date getEndRaiseTime() {
        return endRaiseTime;
    }

    public void setEndRaiseTime(Date endRaiseTime) {
        this.endRaiseTime = endRaiseTime;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getInvestorMax() {
        return investorMax;
    }

    public void setInvestorMax(String investorMax) {
        this.investorMax = investorMax;
    }

    public Date getExpectStartInterestDate() {
        return expectStartInterestDate;
    }

    public void setExpectStartInterestDate(Date expectStartInterestDate) {
        this.expectStartInterestDate = expectStartInterestDate;
    }

    public Date getExpectEndInterestDate() {
        return expectEndInterestDate;
    }

    public void setExpectEndInterestDate(Date expectEndInterestDate) {
        this.expectEndInterestDate = expectEndInterestDate;
    }

    public Date getExpectDuration() {
        return expectDuration;
    }

    public void setExpectDuration(Date expectDuration) {
        this.expectDuration = expectDuration;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getBenefitRate() {
        return benefitRate;
    }

    public void setBenefitRate(String benefitRate) {
        this.benefitRate = benefitRate;
    }

    public String getAnnualizedRate() {
        return annualizedRate;
    }

    public void setAnnualizedRate(String annualizedRate) {
        this.annualizedRate = annualizedRate;
    }

    public String getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(String isPayment) {
        this.isPayment = isPayment;
    }

    public String getSummay() {
        return summay;
    }

    public void setSummay(String summay) {
        this.summay = summay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
