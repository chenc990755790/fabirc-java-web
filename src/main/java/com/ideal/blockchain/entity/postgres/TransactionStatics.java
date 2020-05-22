package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import java.math.BigInteger;

@Data
public class TransactionStatics {

    private String createdt;

    private BigInteger count;

    public TransactionStatics() {
    }

    public TransactionStatics(String createdt, BigInteger count) {
        this.createdt = createdt;
        this.count = count;
    }
}
