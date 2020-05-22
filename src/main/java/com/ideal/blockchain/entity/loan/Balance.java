package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "LMT_BALANCE")
@Entity
@Data
public class Balance {
    private static final String OBJECT_TYPE_NAME = "Balance";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Id
    @Column(name="TRADE_ACCOUNT_ID")
    @ApiModelProperty(value = "交易账户")
    private String tradeAccountId;
    @Column(name="BALANCE")
    @ApiModelProperty(value = "总余额")
    private String balance;
    @Column(name="AVAILABLE")
    @ApiModelProperty(value = "可用余额")
    private String available;
    @Column(name="TRANSIT")
    @ApiModelProperty(value = "在途")
    private String transit;
    @Column(name="CURRENCY")
    @ApiModelProperty(value = "币种")
    private String currency;
    @Column(name="CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @Column(name="LAST_UPDATE_TIME")
    @ApiModelProperty(value = "上次更新时间")
    private String lastUpdateTime;
    @Column(name="DATA_DATE")
    @ApiModelProperty(value = "数据日期")
    private String data_date;
}
