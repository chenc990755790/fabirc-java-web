package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "peer_ref_chaincode")
@Data
public class PeerRefChaincode {

    @Id
    private String id;

    private String peerid;

    private String chaincodeid;

    @Column(name = "cc_version")
    private String ccVersion;

    private String channelid;

    private Date createdt;
}
