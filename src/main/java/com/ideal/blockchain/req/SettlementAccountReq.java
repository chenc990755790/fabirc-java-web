package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.SettlementAccount;
import lombok.Data;

import javax.validation.Valid;

@Data
public class SettlementAccountReq extends InvokeChainCodeArgsReq {

    @Valid
    private SettlementAccount settlementAccount;
}
