package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_REPAY_PLAN")
@Entity
@Data
public class RepayPlan {

    private static final String OBJECT_TYPE_NAME = "RepayPlan";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "所属明细资产编号")
    @Id
    @Column(name = "LOAN_NO")
    public String loanNo;

    @ApiModelProperty(value = "还款期数")
    @Column(name = "ISSUE")
    public String issue;

    @ApiModelProperty(value = "还款日期")
    @Column(name = "DUE_DATE")
    public Date dueDate;

    @ApiModelProperty(value = "应支付对价")
    @Column(name = "PRINCIPAL_DUE")
    public String principalDue;

    @ApiModelProperty(value = "应还对价费用")
    @Column(name = "INTEREST_DUE")
    public String interestDue;

    @ApiModelProperty(value = "应还担保费")
    @Column(name = "SECURITY_CHARGE_DUE")
    public String securityChargeDue;

    @ApiModelProperty(value = "应还服务费")
    @Column(name = "SERVICE_CHARGE_DUE")
    public String serviceChargeDue;

    @ApiModelProperty(value = "应还手续费")
    @Column(name = "CHARGE_MONEY_DUE")
    public String chargeMoneyDue;

    @ApiModelProperty(value = "其他费用")
    @Column(name = "OTHER_PAYMENT_DUE")
    public String otherPaymentDue;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

}
