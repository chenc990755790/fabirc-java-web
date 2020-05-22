package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.CustAccountInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CustAccountInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private CustAccountInfo custAccountInfo;
}
