package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "chaincodes")
@Data
public class Chaincodes {

    @Id
    private String id;

    private String name;

    private String version;

    private String path;

    @Column(name = "channel_genesis_hash")
    private String channelGenesisHash;

    private int txcount;

    private Date createdt;
}
