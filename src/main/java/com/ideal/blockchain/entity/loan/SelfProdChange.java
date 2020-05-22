package com.ideal.blockchain.entity.loan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "LMT_SELF_PROD_CHANGE")
@Entity
@Data
public class SelfProdChange {

    private static final String OBJECT_TYPE_NAME = "SelfProdChange";
    @Transient
    private String objectType = OBJECT_TYPE_NAME;

    @ApiModelProperty(value = "产品编号")
    @Id
    @Column(name = "PROD_NO")
    public String prodNo;

    @ApiModelProperty(value = "产品状态")
    @Column(name = "REQ_TYPE")
    public String reqType;

    @ApiModelProperty(value = "变更日期")
    @Column(name = "REQ_TIME")
    public String reqTime;

    @ApiModelProperty(value = "数据日期")
    @Column(name = "UPDATE_DATE")
    public Date updateDate;
}
