package com.ideal.blockchain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Enterprise{

    private static final String OBJECT_TYPE_NAME="enterprise";

    private String objectType = OBJECT_TYPE_NAME;

    private String id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private String createdUser;

    private String addr;

}