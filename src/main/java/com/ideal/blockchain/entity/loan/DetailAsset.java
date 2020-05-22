package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "LMT_DETAIL_ASSET")
@Entity
@Data
public class DetailAsset {
    private static final String OBJECT_TYPE_NAME = "DetailAsset";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Id
    @Column(name = "LOAN_NO")
    @ApiModelProperty(value = "明细资产编号")
    private String loanNo;
    @Column(name = "PARENT_LOAN_NO")
    @ApiModelProperty(value = "所属资产池编号")
    private String parentLoanNo;
    @Column(name = "LOAN_NAME")
    @ApiModelProperty(value = "明细资产名称")
    private String loanName;
    @Column(name = "CONTRACT_NO")
    @ApiModelProperty(value = "明细资产合同编号")
    private String contractNo;
    @Column(name = "CONTRACT_AMOUNT")
    @ApiModelProperty(value = "明细资产规模")
    private String contractAmount;
    @Column(name = "LOAN_TYPE")
    @ApiModelProperty(value = "明细资产类型")
    private String loanType;
    @Column(name = "CONTRACT_CREDITOR")
    @ApiModelProperty(value = "基础交易合同债权人")
    private String contractCreditor;
    @Column(name = "CONTRACT_DEBTOR")
    @ApiModelProperty(value = "基础交易合同债务人")
    private String contractDebtor;
    @Column(name = "INTEREST_START_DATE")
    @ApiModelProperty(value = "资产开始日")
    private String interestStartDate;
    @Column(name = "INTEREST_END_DATE")
    @ApiModelProperty(value = "资产到期日")
    private String interestEndDate;
    @Column(name = "LOAN_TERM_TYPE")
    @ApiModelProperty(value = "资产期限")
    private String loanTermType;
    @Column(name = "ACTUAL_PAY_DATE")
    @ApiModelProperty(value = "实际支付日")
    private String actualPayDate;
    @Column(name = "PAYMENT_TYPE")
    @ApiModelProperty(value = "还款方式")
    private String paymentType;
    @Column(name = "LOAN_MARGIN_AMOUNT")
    @ApiModelProperty(value = "保证金")
    private String loanMarginAmount;
    @Column(name = "IS_THIRDPARTY_WARRANTY")
    @ApiModelProperty(value = "是否第三方担保")
    private String isThirdpartyWarranty;
    @Column(name = "WARRANTY_TYPE")
    @ApiModelProperty(value = "保证人担保方式")
    private String warrantyType;
    @Column(name = "WARRANTOR_NAME")
    @ApiModelProperty(value = "保证人姓名")
    private String warrantorName;
    @Column(name = "WARRANTOR_TYPE")
    @ApiModelProperty(value = "保证人类型")
    private String warrantorType;
    @Column(name = "WARRANTOR_CREDIT_LEVEL")
    @ApiModelProperty(value = "保证人信用评级")
    private String warrantorCreditLevel;
    @Column(name = "WARRANTOR_AMOUNT")
    @ApiModelProperty(value = "保证人担保金额")
    private String warrantorAmount;
    @Column(name = "UPDATE_DATE")
    @ApiModelProperty(value = "数据更新日期")
    private String updateDate;
}
