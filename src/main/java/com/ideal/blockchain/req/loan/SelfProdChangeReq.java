package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.SelfProdChange;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class SelfProdChangeReq  extends InvokeChainCodeArgsReq {

    @Valid
    private SelfProdChange selfProdChange;
}
