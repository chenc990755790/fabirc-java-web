package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "LMT_ASSET_INFO")
@Entity
@Data
public class AssetInfo {

    private static final String OBJECT_TYPE_NAME = "AssetInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Id
    @Column(name = "LOAN_NO")
    @ApiModelProperty(value = "（资产池编号）资产批次编号")
    private String loanNo;
    @Column(name = "LOAN_NAME")
    @ApiModelProperty(value = "（资产池名称）资产批次名称")
    private String loanName;
    @Column(name = "LOAN_TYPE")
    @ApiModelProperty(value = "（资产池类型）资产批次类型")
    private String loanType;
    @Column(name="CONTRACT_NO")
    @ApiModelProperty(value = "（资产池合同编号）资产批次合同编号")
    private String contractNo;
    @Column(name = "INTEREST_START_DATE")
    @ApiModelProperty(value = "（起息日）资产交割日")
    private String interestStartDate;
    @Column(name = "INTEREST_END_DATE")
    @ApiModelProperty(value = "（止息日）资产到期日")
    private String interestEndDate;
    @Column(name = "CONTRACT_AMOUNT")
    @ApiModelProperty(value = "（资产池规模）资产批次规模")
    private String contractAmount;
    @Column(name = "PRIMARY_RATE")
    @ApiModelProperty(value = "（年化收益率）资产转让预计收益率")
    private String primaryRate;
    @Column(name = "EXPECT_INCOME_AMOUNT")
    @ApiModelProperty(value = "预期收益金额")
    private String expectIncomeAmount;
    @Column(name = "ONCE_CASH_FLOW_AMOUNT")
    @ApiModelProperty(value = "一次性现金流")
    private String onceCashFlowAmount;
    @Column(name = "LOAN_TERM_TYPE")
    @ApiModelProperty(value = "资产期限")
    private String loanTermType;
    @Column(name = "PURPOSE_HOLDING")
    @ApiModelProperty(value = "持有目的")
    private String purposeHolding;
    @Column(name = "LOAN_MARGIN_AMOUNT")
    @ApiModelProperty(value = "保证金")
    private String loanMarginAmount;
    @Column(name = "是否第三方担保")
    @ApiModelProperty(value = "IS_THIRDPARTY_WARRANTY")
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
    @Column(name = "LOAN_ACQUISITION_TYPE")
    @ApiModelProperty(value = "挂牌标的来源（资产获取方式）")
    private String loanAcquisitionType;
    @Column(name = "HOLDER_TYPE")
    @ApiModelProperty(value = "持有方类型")
    private String holderType;
    @Column(name = "持有方名称")
    @ApiModelProperty(value = "HOLDER_NAME")
    private String holderName;
    @Column(name = "TRANSFER_STATUS")
    @ApiModelProperty(value = "是否存在受托管理人（是否过手）")
    private String transferStatus;
    @Column(name = "LOAN_FILTER_STATUS")
    @ApiModelProperty(value = "审核状态----无字典")
    private String loanFilterStatus;
    @Column(name = "UPDATE_DATE")
    @ApiModelProperty(value = "数据更新日期")
    private String updateDate;
    @Column(name = "PROJECT_NO")
    @ApiModelProperty(value = "所属项目编号")
    private String projectNo;
}
