package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "peer")
@Data
public class Peer {

    @Id
    private String id;

    private String org;

    @Column(name = "channel_genesis_hash")
    private String channelGenesisHash;

    private String mspid;

    private String requests;

    private String events;

    @Column(name = "server_hostname")
    private String serverHostname;

    private Date createdt;

    @Column(name = "peer_type")
    private String peerType;
}
