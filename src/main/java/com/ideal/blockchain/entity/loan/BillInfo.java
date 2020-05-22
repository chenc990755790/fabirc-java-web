package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_BILL_INFO")
@Entity
@Data
public class BillInfo {

    private static final String OBJECT_TYPE_NAME = "BillInfo";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "所属明细资产编号")
    @Id
    @Column(name = "LOAN_NO")
    public String loanNo;

    @ApiModelProperty(value = "发票号码")
    @Column(name = "INVOICE_NO")
    public String invoiceNo;

    @ApiModelProperty(value = "发票代码")
    @Column(name = "INVOICE_CODE")
    public String invoiceCode;

    @ApiModelProperty(value = "查验状态")
    @Column(name = "PASSED_AFTER_INSPECTION")
    public String passedAfterInspection;

    @ApiModelProperty(value = "作废状态")
    @Column(name = "WHETHER_IS_INVALID")
    public String whetherIsInvalid;

    @ApiModelProperty(value = "中登登记状态")
    @Column(name = "WHETHER_REGISTER_ZHONGDENG")
    public String whetherRegisterZhongdeng;

    @ApiModelProperty(value = "发票日期")
    @Column(name = "INVOICE_DATE")
    public Date invoiceDate;

    @ApiModelProperty(value = "发票含税金额")
    @Column(name = "INVOICE_HAS_TAX_AMOUNT")
    public String invoiceHasTaxAmount;

    @ApiModelProperty(value = "数据更新日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;
}
