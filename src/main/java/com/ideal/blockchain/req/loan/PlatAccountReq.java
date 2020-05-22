package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.PlatAccount;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class PlatAccountReq  extends InvokeChainCodeArgsReq {

    @Valid
    private PlatAccount platAccount;
}
