package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_REPAY_INFO")
@Entity
@Data
public class RepayInfo {

    private static final String OBJECT_TYPE_NAME = "RepayInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "所属明细资产编号")
    @Id
    @Column(name = "LOAN_NO")
    public String loanNo;

    @ApiModelProperty(value = "还款期数")
    @Column(name = "CURRENT_ISSUE")
    public String currentIssue;

    @ApiModelProperty(value = "本期状态")
    @Column(name = "CURRENT_ISSUE_STATUS")
    public String currentIssueStatus;

    @ApiModelProperty(value = "还款日期")
    @Column(name = "PAY_DATE")
    public Date payDate;

    @ApiModelProperty(value = "实还本金")
    @Column(name = "PRINCIPAL_PAID")
    public String principalPaid;

    @ApiModelProperty(value = "实还利息")
    @Column(name = "INTEREST_PAID")
    public String interestPaid;

    @ApiModelProperty(value = "实还担保费")
    @Column(name = "SECURITY_CHARGE_PAID")
    public String securityChargePaid;

    @ApiModelProperty(value = "实还服务费")
    @Column(name = "SERVICE_CHARGE_PAID")
    public String serviceChargePaid;

    @ApiModelProperty(value = "实还手续费")
    @Column(name = "CHARGE_MONEY_PAID")
    public String chargeMoneyPaid;

    @ApiModelProperty(value = "其他费用")
    @Column(name = "OTHER_PAYMENT_PAID")
    public String otherPaymentPaid;

    @ApiModelProperty(value = "逾期金额")
    @Column(name = "OVERDUE_AMOUNT")
    public String overdueAmount;

    @ApiModelProperty(value = "逾期天数")
    @Column(name = "OVERDUE_ARREARS")
    public String overdueArrears;

    @ApiModelProperty(value = "代偿日期")
    @Column(name = "SUBSTITUTION_PAYMENT_DATE")
    public Date substitutionPaymentDate;

    @ApiModelProperty(value = "代偿金额")
    @Column(name = "SUBSTITUTION_PAYMENT_AMOUNT")
    public String substitutionPaymentAmount;

    @ApiModelProperty(value = "连续逾期次数")
    @Column(name = "CONTINUOUS_TIMES_OVERDUE")
    public String continuousTimesOverdue;

    @ApiModelProperty(value = "累计逾期次数")
    @Column(name = "ACCUMULATE_OVERDUE_TIMES")
    public String accumulateOverdueTimes;

    @ApiModelProperty(value = "累计代偿次数")
    @Column(name = "SUBSTITUTE_PAYMENT_TIMES")
    public String substitutePaymentTimes;

    @ApiModelProperty(value = "应还罚息累计")
    @Column(name = "DUE_PENALTY_TOTAL_AMOUNT")
    public String duePenaltyTotalAmount;

    @ApiModelProperty(value = "实还罚息累计")
    @Column(name = "PAID_PENALTY_TOTAL_AMOUNT")
    public String paidPenaltyTotalAmount;

    @ApiModelProperty(value = "剩余应还罚息")
    @Column(name = "SURPLUS_PENALTY_AMOUNT")
    public String surplusPenaltyAmount;

    @ApiModelProperty(value = "待抵扣保证金")
    @Column(name = "DEDUCTION_MARGIN_AMOUNT")
    public String deductionMarginAmount;

    @ApiModelProperty(value = "")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

}
