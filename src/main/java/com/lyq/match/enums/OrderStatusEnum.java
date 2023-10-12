package com.lyq.match.enums;

/**
 * @author lyq
 * @date 2023-10-12 11:04
 * @describe 订单状态枚举  新订单状态变化 下单（等待成交）-成交（部分成交）-成交（完全成交）
 */
public enum OrderStatusEnum {

    WAIT_DEAL("PART_DEAL", "等待成交"),

    PART_DEAL("PART_DEAL", "部分成交"),

    ALL_DEAL("ALL_DEAL", "完全成交");


    private String code;

    private String desc;

    OrderStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static OrderStatusEnum getOrderStatusEnumByCode(String code) {
        for (OrderStatusEnum value : OrderStatusEnum.values()) {
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
