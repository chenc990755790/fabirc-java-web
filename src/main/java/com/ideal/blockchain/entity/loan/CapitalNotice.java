package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_CAPITAL_NOTICE")
@Entity
@Data
public class CapitalNotice {

    private static final String OBJECT_TYPE_NAME = "CapitalNotice";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "线下资金通知编号")
    @Id
    @Column(name = "CAPITAL_NOTICE_ID")
    public String capitalNoticeId;

    @ApiModelProperty(value = "通道")
    @Column(name = "CAPITAL_CHANNEL_ID")
    public String capitalChannelId;

    @ApiModelProperty(value = "金额")
    @Column(name = "AMOUNT")
    public String amount;

    @ApiModelProperty(value = "通知处理状态 参考NOTICE_DEAL_STATUS")
    @Column(name = "DEAL_STATUS")
    public String dealStatus;

    @ApiModelProperty(value = "渠道返回时间")
    @Column(name = "RESPONSE_TIME")
    public Date responseTime;

    @ApiModelProperty(value = "渠道返回工作日")
    @Column(name = "RESPONSE_WORKDAY")
    public String responseWorkday;

    @ApiModelProperty(value = "姓名")
    @Column(name = "BANK_ACCOUNT_NAME")
    public String bankAccountName;

    @ApiModelProperty(value = "银行账号")
    @Column(name = "BANK_ACCOUNT_NO")
    public String bankAccountNo;

    @ApiModelProperty(value = "渠道订单号(BIS)")
    @Column(name = "CHANNEL_ORDER_NO")
    public String channelOrderNo;

    @ApiModelProperty(value = "渠道通知订单号(渠道)")
    @Column(name = "NOTICE_ORDER_NO")
    public String noticeOrderNo;

    @ApiModelProperty(value = "联行号")
    @Column(name = "BANK_BRANCH_CODE")
    public String bankBranchCode;

    @ApiModelProperty(value = "联行名")
    @Column(name = "BANK_BRANCH")
    public String bankBranch;

    @ApiModelProperty(value = "关联的资金申请编号")
    @Column(name = "CAPITAL_REQ_ID")
    public String capitalReqId;

    @ApiModelProperty(value = "")
    @Column(name = "CREATE_TIME")
    public Date createTime;

    @ApiModelProperty(value = "")
    @Column(name = "LAST_UPDATE_TIME")
    public Date lastUpdate_time;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "DATA_DATE")
    public Date dataDate;

}
