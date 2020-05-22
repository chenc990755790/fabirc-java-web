package com.ideal.blockchain.entity.postgres;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
public class Transactions {

    @Id
    private String id;

    private int blockid;

    private String txhash;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Date createdt;

    private String chaincodename;

    private String status;

    @Column(name = "creator_msp_id")
    private String creatorMspId;

    @Column(name = "endorser_msp_id")
    private String endorserMspId;

    @Column(name = "chaincode_id")
    private String chaincodeId;

    private String type;

    @Column(name = "read_set")
    private String readSet;

    @Column(name = "write_set")
    private String writeSet;

    @Column(name = "channel_genesis_hash")
    private String channelGenesisHash;

    @Column(name = "validation_code")
    private String validationCode;

    @Column(name = "envelope_signature")
    private String envelopeSignature;

    @Column(name = "payload_extension")
    private String payloadExtension;

    @Column(name = "creator_id_bytes")
    private String creatorIdBytes;

    @Column(name = "creator_nonce")
    private String creatorNonce;

    @Column(name = "chaincode_proposal_input")
    private String chaincodeProposalInput;

    @Column(name = "tx_response")
    private String txResponse;

    @Column(name = "payload_proposal_hash")
    private String payloadProposalHash;

    @Column(name = "endorser_id_bytes")
    private String endorserIdBytes;

    @Column(name = "endorser_signature")
    private String endorserSignature;
}
