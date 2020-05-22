package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_SELF_PROD_PAYMENT")
@Entity
@Data
public class SelfProdPayment {

    private static final String OBJECT_TYPE_NAME = "SelfProdPayment";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "产品兑付编号")
    @Id
    @Column(name = "PRODUCT_PAYMENT_ID")
    public String productPaymentId;


    @ApiModelProperty(value = "产品编号")
    @Column(name = "PROD_NO")
    public String prodNo;


    @ApiModelProperty(value = "转付本金金额")
    @Column(name = "VOLUME")
    public String volume;


    @ApiModelProperty(value = "实际收益金额")
    @Column(name = "ACTUAL_INTEREST")
    public String actualInterest;


    @ApiModelProperty(value = "产品转付日期")
    @Column(name = "PAY_BACK_TIME")
    public Date payBackTime;


    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;
}
