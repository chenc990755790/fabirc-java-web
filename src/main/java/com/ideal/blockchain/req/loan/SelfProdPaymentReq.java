package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.SelfProdPayment;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class SelfProdPaymentReq  extends InvokeChainCodeArgsReq {

    @Valid
    private SelfProdPayment selfProdPayment;
}
