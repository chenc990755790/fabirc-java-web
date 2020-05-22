package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "LMT_CAPITAL_DIVERT")
@Data
public class CapitalDivert {
    private static final String OBJECT_TYPE_NAME = "CapitalDivert";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;
    @Id
    @Column(name = "CAPITAL_DIVERT_ID")
    @ApiModelProperty(value = "资金划转编号")
    private String capitalDivertId;
    @Column(name = "DIVERT_TYPE")
    @ApiModelProperty(value = "划转类型 参考CAPITAL_DIVERT_TYPE")
    private String divertType;
    @Column(name = "CAPITAL_CHANNEL_ID")
    @ApiModelProperty(value = "通道")
    private String capitalChannelId;
    @Column(name = "AMOUNT")
    @ApiModelProperty(value = "金额")
    private String amount;
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态 参考PAY_STATUS")
    private String status;
    @Column(name = "REQUEST_TIME")
    @ApiModelProperty(value = "申请时间")
    private String requestTime;
    @Column(name = "BANK_CODE")
    @ApiModelProperty(value = "银行编码")
    private String bankCode;
    @Column(name = "BANK_ACCOUNT_NAME")
    @ApiModelProperty(value = "银行户名")
    private String bankAccountName;
    @Column(name = "BANK_ACCOUNT_NO")
    @ApiModelProperty(value = "银行账号")
    private String bankAccountNo;
    @Column(name = "BANK_BRANCH")
    @ApiModelProperty(value = "联行名")
    private String bankBranch;
    @Column(name = "BANK_BRANCH_CODE")
    @ApiModelProperty(value = "联行号")
    private String bankBranchCode;
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "")
    private String createTime;
    @Column(name = "LAST_UPDATE_TIME")
    @ApiModelProperty(value = "")
    private String lastUpdateTime;
    @Column(name = "DATA_DATE")
    @ApiModelProperty(value = "数据日期")
    private String dataDate;
}
