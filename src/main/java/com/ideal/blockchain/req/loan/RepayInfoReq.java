package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.RepayInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class RepayInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private RepayInfo repayInfo;
}
