package com.ideal.blockchain.req.loan;

import com.ideal.blockchain.entity.loan.AssetInfo;
import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import lombok.Data;

import javax.validation.Valid;

@Data
public class AssetInfoReq  extends InvokeChainCodeArgsReq {

    @Valid
    private AssetInfo assetInfo;
}
