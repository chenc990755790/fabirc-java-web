package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_CUST_PAYMENT")
@Entity
@Data
public class CustPayment {

    private static final String OBJECT_TYPE_NAME = "CustPayment";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "客户兑付编号")
    @Id
    @Column(name = "CUSTOMER_PAYMENT_ID")
    public String customerPaymentId;

    @ApiModelProperty(value = "产品编号")
    @Column(name = "PROD_NO")
    public String prodNo;

    @ApiModelProperty(value = "交易账号")
    @Column(name = "TRADE_ACCOUNT_ID")
    public String tradeAccountId;

    @ApiModelProperty(value = "转付本金金额")
    @Column(name = "VOLUME")
    public String volume;

    @ApiModelProperty(value = "实际收益金额")
    @Column(name = "ACTUAL_INTEREST")
    public String actualInterest;

    @ApiModelProperty(value = "产品兑付编号")
    @Column(name = "PRODUCT_PAYMENT_ID")
    public String productPaymentId;

    @ApiModelProperty(value = "兑付时间")
    @Column(name = "PAY_BACK_TIME")
    public Date payBackTime;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

}
