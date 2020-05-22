package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.DetailAsset;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class DetailAssetReq   extends InvokeChainCodeArgsReq {

    @Valid
    private DetailAsset detailAsset;
}
