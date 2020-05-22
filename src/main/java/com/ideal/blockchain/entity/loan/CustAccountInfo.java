package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_CUST_ACCOUNT_INFO")
@Entity
@Data
public class CustAccountInfo {

    private static final String OBJECT_TYPE_NAME = "CustAccountInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "交易账号")
    @Id
    @Column(name = "TRADE_ACCOUNT_ID")
    public String tradeAccountId;

    @ApiModelProperty(value = "客户名称")
    @Column(name = "CUST_NAME")
    public String custName;

    @ApiModelProperty(value = "身份证号")
    @Column(name = "ID_NUMBER")
    public String idNumber;

    @ApiModelProperty(value = "绑定银行")
    @Column(name = "BANK_CODE")
    public String bankCode;

    @ApiModelProperty(value = "金额")
    @Column(name = "AMOUNT")
    public String amount;

    @ApiModelProperty(value = "余额")
    @Column(name = "BALANCE")
    public String balance;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

    @ApiModelProperty(value = "")
    @Column(name = "ID")
    public String id;
}
