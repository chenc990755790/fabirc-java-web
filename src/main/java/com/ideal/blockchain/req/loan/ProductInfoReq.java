package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.ProductInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class ProductInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private ProductInfo productInfo;
}
