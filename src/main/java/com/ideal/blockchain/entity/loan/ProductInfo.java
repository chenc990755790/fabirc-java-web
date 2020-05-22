package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_PRODUCT_INFO")
@Entity
@Data
public class ProductInfo {

    private static final String OBJECT_TYPE_NAME = "ProductInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "资产池编号")
    @Id
    @Column(name = "ASSET_PACKAGE_ID")
    public String assetPackageId;


    @ApiModelProperty(value = "产品ID")
    @Column(name = "PROD_ID")
    public String prodId;


    @ApiModelProperty(value = "产品名称")
    @Column(name = "PROD_NAME")
    public String prodName;


    @ApiModelProperty(value = "挂牌标的总金额")
    @Column(name = "HANG_VOLUME")
    public String hangVolume;


    @ApiModelProperty(value = "挂牌日期")
    @Column(name = "HANG_DATE")
    public Date hangDate;


    @ApiModelProperty(value = "交易模式")
    @Column(name = "TRADE_TYPE")
    public String tradeMode;


    @ApiModelProperty(value = "最低购买金额")
    @Column(name = "SINGLE_SUBSCRIBE_MIN")
    public String singleSubscribeMin;


    @ApiModelProperty(value = "募集起始日")
    @Column(name = "START_RAISE_TIME")
    public Date startRaiseTime;


    @ApiModelProperty(value = "募集终止日")
    @Column(name = "END_RAISE_TIME")
    public Date endRaiseTime;


    @ApiModelProperty(value = "产品状态编码")
    @Column(name = "STATUS_CODE")
    public String statusCode;


    @ApiModelProperty(value = "投资人数上限")
    @Column(name = "INVESTOR_MAX")
    public String investorMax;


    @ApiModelProperty(value = "产品起息日")
    @Column(name = "EXPECT_START_INTEREST_DATE")
    public Date expectStartInterestDate;


    @ApiModelProperty(value = "产品到期日")
    @Column(name = "EXPECT_END_INTEREST_DATE")
    public Date expectEndInterestDate;


    @ApiModelProperty(value = "预计存续期")
    @Column(name = "EXPECT_DURATION")
    public Date expectDuration;


    @ApiModelProperty(value = "产品风险等级")
    @Column(name = "RISK_LEVEL")
    public String riskLevel;


    @ApiModelProperty(value = "预期获益率")
    @Column(name = "BENEFITRATE")
    public String benefitRate;


    @ApiModelProperty(value = "预期年化收益率")
    @Column(name = "ANNUALIZEDRATE")
    public String annualizedRate;


    @ApiModelProperty(value = "是否已兑付")
    @Column(name = "IS_PAYMENT")
    public String isPayment;


    @ApiModelProperty(value = "转付金额")
    @Column(name = "SUMMAY")
    public String summay;


    @ApiModelProperty(value = "转付日期")
    @Column(name = "PAY_DATE")
    public Date payDate;


    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

}
