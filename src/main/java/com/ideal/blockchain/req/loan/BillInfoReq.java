package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.BillInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class BillInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private BillInfo billInfo;
}
