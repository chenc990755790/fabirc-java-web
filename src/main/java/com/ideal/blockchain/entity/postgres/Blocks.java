package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "blocks")
@Data
public class Blocks {
    @Id
    private String id;

    private int blocknum;

    private String datahash;

    private String prehash;

    private int txcount;

    private Date createdt;
    @Column(name = "prev_blockhash")
    private String prevBlockhash;

    private String blockhash;

    @Column(name = "channel_genesis_hash")
    private String channelGenesisHash;
}
