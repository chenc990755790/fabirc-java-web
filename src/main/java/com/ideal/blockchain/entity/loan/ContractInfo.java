package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "LMT_CONTRACT_INFO")
@Entity
@Data
public class ContractInfo {

    private static final String OBJECT_TYPE_NAME = "ContractInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Column(name = "BELONG_TO")
    @ApiModelProperty(value = "合同所属位置")
    private String belongTo;
    @Id
    @Column(name = "LOAN_NO")
    @ApiModelProperty(value = "合同所属资产编号")
    private String loanNo;
    @Column(name = "NAME")
    @ApiModelProperty(value = "合同名称")
    private String name;
    @Column(name = "CONTRACT_NO")
    @ApiModelProperty(value = "合同编号")
    private String contractNo;
    @Column(name = "CONTRACT_AMOUNT")
    @ApiModelProperty(value = "合同金额")
    private String contractAmount;
    @Column(name = "CONTRACT_TYPE")
    @ApiModelProperty(value = "合同类型")
    private String contractType;
    @Column(name = "SIGNING_DATE")
    @ApiModelProperty(value = "合同签署日")
    private String signingDate;
    @Column(name = "START_DATE")
    @ApiModelProperty(value = "合同开始日")
    private String startDate;
    @Column(name = "END_DATE")
    @ApiModelProperty(value = "合同结束日")
    private String endDate;
    @Column(name = "BUYER_NAME")
    @ApiModelProperty(value = "购买方/资金方")
    private String buyerName;
    @Column(name = "SELLER_NAME")
    @ApiModelProperty(value = "销售方/资产转让方")
    private String sellerName;
    @Column(name = "IS_FINANCIN_CONTRACT")
    @ApiModelProperty(value = "是否为金融服务类合同")
    private String isFinancinContract;
    @Column(name = "RECEIVABLE_AMOUNT")
    @ApiModelProperty(value = "应收账款转让金额")
    private String receivableAmount;
    @Column(name = "RECEIVABLE_TRANSFER_DATE")
    @ApiModelProperty(value = "应收账款转让日")
    private String receivableTransferDate;
    @Column(name = "RECEIVABLE_PAYMENT_DATE")
    @ApiModelProperty(value = "应收账款支付日")
    private String receivablePaymentDate;
    @Column(name = "COLLECTION_METHOD")
    @ApiModelProperty(value = "收费费率收取方式")
    private String collectionMethod;
    @Column(name = "INTEREST_RATE")
    @ApiModelProperty(value = "收费费率")
    private String interestRate;
    @Column(name = "OTHER_PAYMENT_METHOD")
    @ApiModelProperty(value = "其他费用收取方式")
    private String otherPaymentMethod;
    @Column(name = "OTHER_INTEREST_RATE")
    @ApiModelProperty(value = "其他费用利率")
    private String otherInterestRate;
    @Column(name = "IS_SIGNED_BY_LEGAL")
    @ApiModelProperty(value = "是否为法人签署")
    private String isSignedByLegal;
    @Column(name = "UPDATE_DATE")
    @ApiModelProperty(value = "数据更新日期")
    private String updateDate;
}
