package com.ideal.blockchain.entity.postgres;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "channel")
@Data
public class Channel {

    @Id
    private String id;

    private String name;

    private int blocks;

    private String trans;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Date createdt;

    @Column(name = "channel_genesis_hash")
    private String channelGenesisHash;

    @Column(name = "channel_hash")
    private String channelHash;

    @Column(name = "channel_config")
    private Byte[] channelConfig;

    @Column(name = "channel_block")
    private Byte[] channelBlock;

    @Column(name = "channel_tx")
    private Byte[] channelTx;

    @Column(name = "channel_version")
    private String channelVersion;
}
