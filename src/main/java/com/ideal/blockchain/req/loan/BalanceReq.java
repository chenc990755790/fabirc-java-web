package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.Balance;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class BalanceReq  extends InvokeChainCodeArgsReq {

    @Valid
    private Balance balance;
}
