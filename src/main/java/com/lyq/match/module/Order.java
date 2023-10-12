package com.lyq.match.module;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author lyq
 * @date 2023-10-12 11:02
 * @describe
 */
@Data
public class Order {

    /**
     * id
     */
    private Long id;

    /**
     * 时间
     */
    private Long time;

    /**
     * 订单类型
     */
    private String type;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 订单方向
     */
    private String direction;

    /**
     * 币对
     */
    private String symbol;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private BigDecimal amount;

    /**
     * 已成交数量
     */
    private BigDecimal dealAmount;

    /**
     * 已成交笔数
     */
    private Integer dealNumber;


    private PriceNode priceNode;

    private Order prev;

    private Order next;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return this.id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, time, symbol, direction, price, amount);
    }
}
