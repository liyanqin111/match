package com.lyq.match.enums;

/**
 * @author lyq
 * @date 2023-10-12 11:04
 * @describe 订单方向枚举
 */
public enum OrderDirectionEnum {

    BID("BID", "买"),

    ASK("ASK", "卖");


    private String code;

    private String desc;

    OrderDirectionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static OrderDirectionEnum getOrderDirectionEnumByCode(String code) {
        for (OrderDirectionEnum value : OrderDirectionEnum.values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
