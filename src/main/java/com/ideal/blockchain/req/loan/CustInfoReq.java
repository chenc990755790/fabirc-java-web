package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.CustInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CustInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private CustInfo custInfo;
}
