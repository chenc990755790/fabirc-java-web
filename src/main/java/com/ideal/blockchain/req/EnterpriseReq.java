package com.ideal.blockchain.req;

import com.ideal.blockchain.entity.Enterprise;
import lombok.Data;

import javax.validation.Valid;

@Data
public class EnterpriseReq extends InvokeChainCodeArgsReq {

    @Valid
    private Enterprise enterprise;
}
