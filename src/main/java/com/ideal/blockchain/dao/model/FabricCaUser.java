package com.ideal.blockchain.dao.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`fabric_ca_user`")
@Data
public class FabricCaUser {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`roles`")
    private String roles;

    @Column(name = "`account`")
    private String account;

    @Column(name = "`affiliation`")
    private String affiliation;

    @Column(name = "`organization`")
    private String organization;

    @Column(name = "`enrollmentSecret`")
    private String enrollmentsecret;

    @Column(name = "`enrollment`")
    private String enrollment;

    @Column(name = "`msp_Id`")
    private String mspId;

    @Column(name = "`exp_date`")
    private Date expDate;

    @Column(name = "`create_by`")
    private String createBy;

    @Column(name = "`create_date`")
    private Date createDate;

    @Column(name = "`update_by`")
    private String updateBy;

    @Column(name = "`update_date`")
    private Date updateDate;


}
