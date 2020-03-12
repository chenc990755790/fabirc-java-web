package org.hyperledger.fabric.example.entity;


import java.math.BigDecimal;
import java.util.Date;

public class Credit {

    private String id;

    private String outEnterpriseId;

    private String inEnterpriseId;

    private BigDecimal money;

    private Date createDate;

    private BigDecimal rate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOutEnterpriseId() {
        return outEnterpriseId;
    }

    public void setOutEnterpriseId(String outEnterpriseId) {
        this.outEnterpriseId = outEnterpriseId;
    }

    public String getInEnterpriseId() {
        return inEnterpriseId;
    }

    public void setInEnterpriseId(String inEnterpriseId) {
        this.inEnterpriseId = inEnterpriseId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id='" + id + '\'' +
                ", outEnterpriseId='" + outEnterpriseId + '\'' +
                ", inEnterpriseId='" + inEnterpriseId + '\'' +
                ", money=" + money +
                ", createDate=" + createDate +
                ", rate=" + rate +
                '}';
    }
}
