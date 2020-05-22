package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_PLAT_ACCOUNT")
@Entity
@Data
public class PlatAccount {

    private static final String OBJECT_TYPE_NAME = "PlatAccount";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "交易账号")
    @Id
    @Column(name = "TRADE_ACCOUNT_ID")
    public String tradeAccountId;

    @ApiModelProperty(value = "交易类别")
    @Column(name = "TRADE_TYPE")
    public String tradeType;

    @ApiModelProperty(value = "交易日期")
    @Column(name = "TRADE_DATE")
    public Date tradeDate;

    @ApiModelProperty(value = "交易时间")
    @Column(name = "TRADE_TIME")
    public Date tradeTime;

    @ApiModelProperty(value = "金额")
    @Column(name = "AMOUNT")
    public String amount;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

    @ApiModelProperty(value = "唯一标识")
    @Column(name = "ID")
    public String id;

    @ApiModelProperty(value = "交易状态")
    @Column(name = "TRADE_STATUS")
    public String tradeStatus;
}
