package com.ideal.blockchain.dao.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "collection_config")
@Data
public class CollectionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "collection_name")
    private String collectionName;
    @Column(name = "sign_in_company")
    private String signinCompany;
    @Column(name = "sign_out_company")
    private String signoutCompany;
    @Column(name = "financial_company")
    private String financialCompany;
    @Column(name = "promise_company")
    private String promiseCompany;
}
