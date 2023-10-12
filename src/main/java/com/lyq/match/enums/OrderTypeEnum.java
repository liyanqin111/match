package com.lyq.match.enums;

/**
 * @author lyq
 * @date 2023-10-12 11:04
 * @describe 订单类型枚举
 */
public enum OrderTypeEnum {

    LIMIT("LIMIT","限价"),

    MARKET("MARKET","市价");


    private String code;

    private String desc;

    OrderTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static OrderTypeEnum getOrderTypeEnumByCode(String code) {
        for (OrderTypeEnum value : OrderTypeEnum.values()) {
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
