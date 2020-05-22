package com.ideal.blockchain.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ShuntReq <E>{

    @NotNull(message = "上链数据类型不能为空")
    private String blockBusinessType;

    @NotNull(message = "上链数据不能为空")
    @JsonProperty("shuntData")
    private ShuntData<E> shuntData;

//        private Factor factor;
    @Data
    private static class ShuntData <E>{

        private String blockChainReqId;
        private String businessTypeText;
        private String businessType;
        private E requestData;

    }
}
