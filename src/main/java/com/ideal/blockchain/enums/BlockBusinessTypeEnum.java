package com.ideal.blockchain.enums;

public enum BlockBusinessTypeEnum {

    FACTORING("01", "保理"),

    TRANSFER("02","转让"),

    ENTERPRISE("03","企业信息");

    private String code;
    private String desc;

    BlockBusinessTypeEnum(String code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BlockBusinessTypeEnum getResponseCodeEnum(String value) {
        if (value != null) {
            for (BlockBusinessTypeEnum nameEnum : values()) {
                if (nameEnum.getCode().equals(value)) {
                    return nameEnum;
                }
            }
        }
        return null;
    }

    public static boolean isResponseCodeEnum(String value) {
        if (value != null) {
            for (BlockBusinessTypeEnum nameEnum : values()) {
                if (nameEnum.getCode().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }


}
