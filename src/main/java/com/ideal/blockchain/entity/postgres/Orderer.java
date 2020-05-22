package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "orderer")
@Data
public class Orderer {

    @Id
    private String id;

    private String requests;

    @Column(name = "server_hostname")
    private String serverHostname;

    private Date createdt;
}
