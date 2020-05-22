package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "peer_ref_channel")
@Data
public class PeerRefChannel {

    @Id
    private String id;

    private Date createdt;

    private String peerid;

    private String channelid;

    @Column(name = "peer_type")
    private String peerType;
}
