package com.ideal.blockchain.dto.request;

import com.ideal.blockchain.entity.Enterprise;
import lombok.Data;

@Data
public class EnterpriseReq extends InvokeChainCodeArgsDto {

    private Enterprise enterprise;

}
