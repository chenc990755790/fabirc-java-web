package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.CustPayment;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class CustPaymentReq  extends InvokeChainCodeArgsReq {

    @Valid
    private CustPayment custPayment;
}
