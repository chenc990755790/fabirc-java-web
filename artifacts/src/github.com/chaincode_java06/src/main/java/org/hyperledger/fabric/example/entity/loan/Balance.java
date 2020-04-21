package org.hyperledger.fabric.example.entity.loan;


public class Balance {
    private static final String OBJECT_TYPE_NAME = "Balance";
    private String objectType = OBJECT_TYPE_NAME;
    private String tradeAccountId;
    private String balance;
    private String available;
    private String transit;
    private String currency;
    private String createTime;
    private String lastUpdateTime;
    private String data_date;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getTradeAccountId() {
        return tradeAccountId;
    }

    public void setTradeAccountId(String tradeAccountId) {
        this.tradeAccountId = tradeAccountId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getData_date() {
        return data_date;
    }

    public void setData_date(String data_date) {
        this.data_date = data_date;
    }
}
