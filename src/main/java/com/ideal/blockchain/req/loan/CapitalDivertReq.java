package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.CapitalDivert;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CapitalDivertReq  extends InvokeChainCodeArgsReq {

    @Valid
    private CapitalDivert capitalDivert;
}
