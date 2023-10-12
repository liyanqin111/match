package com.lyq.match.module;

import com.lyq.match.enums.OrderDirectionEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author lyq
 * @date 2023-10-12 10:53
 * @describe 订单薄
 */
@Data
@Slf4j
public class OrderBook {


    /**
     * 币对
     */
    private String symbol;


    /**
     * 卖单第一个价格节点
     */
    private PriceNode askFirst;

    /**
     * 卖单最后一个价格节点
     */
    private PriceNode askLast;

    /**
     * 买单第一个价格节点
     */
    private PriceNode bidFirst;

    /**
     * 买单最后一个价格节点
     */
    private PriceNode bidLast;

    /**
     * 买单薄
     */
    private TreeMap<BigDecimal, PriceNode> bidPriceMap;

    /**
     * 卖单薄
     */
    private TreeMap<BigDecimal, PriceNode> askPriceMap;


    /**
     * 订单上薄
     *
     * @param newOrder
     * @return
     */
    public Boolean addOrder(Order newOrder) {
        String direction = newOrder.getDirection();
        if (OrderDirectionEnum.BID.getCode().equals(direction)) {

        } else if (OrderDirectionEnum.ASK.getCode().equals(direction)) {

        } else {
            log.error("订单无效，无效的方向:{}", direction);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    /**
     * 买单上薄
     *
     * @param newOrder
     * @return
     */
    private Boolean addBidOrder(Order newOrder) {
        BigDecimal price = newOrder.getPrice();
        //订单薄无订单数据
        if (Objects.isNull(this.bidFirst)) {
            //this.bidFirst = newOrder;
        }
        return Boolean.TRUE;
    }


    /**
     * 获取对应价格节点
     *
     * @param price
     * @return
     */
    private PriceNode getAndSetPriceNode(BigDecimal price) {
        //获取买单薄
        if (Objects.isNull(bidPriceMap)) {
            bidPriceMap = new TreeMap<>();
        }
        //获取订单价格水平的价格节点（相同价格订单链表）
        PriceNode priceNode = bidPriceMap.get(price);
        if (Objects.isNull(priceNode)) {
            priceNode = new PriceNode(price, true);
        }
        return priceNode;
    }


}
