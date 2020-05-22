package com.ideal.blockchain.dto.response;

import lombok.Data;

@Data
public class BlockLatestInfo {

    private long blocksCount;

    private long transactionsCount;

    private long peerCount;

    private long chaincodesCount;
}
