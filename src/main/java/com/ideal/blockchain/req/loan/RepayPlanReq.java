package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.RepayPlan;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class RepayPlanReq  extends InvokeChainCodeArgsReq {

    @Valid
    private RepayPlan repayPlan;
}
