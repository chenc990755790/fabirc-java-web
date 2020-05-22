package com.ideal.blockchain.config;

import com.ideal.blockchain.req.InvokeChainCodeArgsReq;
import com.ideal.blockchain.req.QueryArgsReq;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("invokeReq")
    @ConfigurationProperties("invokereq")
    public InvokeChainCodeArgsReq invokeChainCodeArgsReq() {
        return new InvokeChainCodeArgsReq();
    }

    @Bean("queryArgsReq")
    @ConfigurationProperties("queryreq")
    public QueryArgsReq queryArgsReq() {
        return new QueryArgsReq();
    }
}
