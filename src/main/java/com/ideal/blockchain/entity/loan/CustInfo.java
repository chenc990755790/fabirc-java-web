package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "LMT_CUST_INFO")
@Data
public class CustInfo {
    private static final String OBJECT_TYPE_NAME = "CustInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Id
    @Column(name = "PROD_NO")
    @ApiModelProperty(value = "产品ID")
    private String prodNo;
    @Column(name = "TRADE_ACCOUNT_ID")
    @ApiModelProperty(value = "交易账号")
    private String tradeAccountId;
    @Column(name = "SERIAL_NUMBER")
    @ApiModelProperty(value = "唯一识别序号")
    private String serialNumber;
    @Column(name = "PROD_NAME")
    @ApiModelProperty(value = "产品名称")
    private String prodName;
    @Column(name = "CUST_NAME")
    @ApiModelProperty(value = "客户名称")
    private String custName;
    @Column(name = "CUST_TYPE_CODE")
    @ApiModelProperty(value = "客户类型代码")
    private String custTypeCode;
    @Column(name = "REQUEST_TIME")
    @ApiModelProperty(value = "认购时间")
    private String requestTime;
    @Column(name = "PAY_AMOUNT")
    @ApiModelProperty(value = "转付金额")
    private String payAmount;
    @Column(name = "PAY_DATE")
    @ApiModelProperty(value = "转付日期")
    private String payDate;
    @Column(name = "AMOUNT")
    @ApiModelProperty(value = "购买金额")
    private String amount;
    @Column(name = "ASSIGN_PROMISE")
    @ApiModelProperty(value = "准入承诺书")
    private String assignPromise;
    @Column(name = "RISK_RANK")
    @ApiModelProperty(value = "客户风险评级")
    private String riskRank;
    @Column(name = "WHITELIST")
    @ApiModelProperty(value = "白名单")
    private String whitelist;
    @Column(name = "SUPERWHITELIST")
    @ApiModelProperty(value = "超级白名单")
    private String superwhitelist;
    @Column(name = "BANK_ACC_NO")
    @ApiModelProperty(value = "银行账户")
    private String bankAccNo;
    @Column(name = "UPDATE_DATE")
    @ApiModelProperty(value = "数据日期")
    private String updateDate;
}
