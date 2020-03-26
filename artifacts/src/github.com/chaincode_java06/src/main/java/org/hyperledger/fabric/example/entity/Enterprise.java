package org.hyperledger.fabric.example.entity;

import java.util.Date;

public class Enterprise{

    public static final String OBJECT_TYPE_NAME="enterprise";

    private static final String objectType = OBJECT_TYPE_NAME;

    private String id;

    private String name;

    private Date createDate;

    private String createdUser;

    private String addr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectType() {
        return objectType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", createdUser='" + createdUser + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
