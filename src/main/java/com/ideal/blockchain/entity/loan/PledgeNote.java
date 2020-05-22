package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_PLEDGE_NOTE")
@Entity
@Data
public class PledgeNote {

    private static final String OBJECT_TYPE_NAME = "PledgeNote";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;


    @ApiModelProperty(value = "票据所属位置---中文，无字典")
    @Id
    @Column(name = "LOAN_LEVEL_TEXT")
    public String loanLevelText;


    @ApiModelProperty(value = "票据所属资产编号")
    @Column(name = "LOAN_NO")
    public String loanNo;


    @ApiModelProperty(value = "质押票据号码")
    @Column(name = "PLEDGED_BILL_NUMBER")
    public String pledgedBillNumber;


    @ApiModelProperty(value = "押品类型")
    @Column(name = "COLLERTAL_MODEL")
    public String collertalModel;


    @ApiModelProperty(value = "票据类型")
    @Column(name = "BILL_TYPE")
    public String billType;


    @ApiModelProperty(value = "票面金额")
    @Column(name = "BILL_AMOUNT")
    public String billAmount;


    @ApiModelProperty(value = "出票日期")
    @Column(name = "ISSUE_DATE")
    public Date issueDate;


    @ApiModelProperty(value = "到期日期")
    @Column(name = "EXPIRY_DATE")
    public Date expiryDate;


    @ApiModelProperty(value = "出票人名称")
    @Column(name = "DRAWER_NAME")
    public String drawerName;


    @ApiModelProperty(value = "承兑人名称")
    @Column(name = "BILL_ACCEPTOR")
    public String billAcceptor;


    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;

}
