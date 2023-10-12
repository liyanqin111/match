package com.lyq.match.module;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author lyq
 * @date 2023-10-12 11:29
 * @describe 价格节点
 */
@Data
public class PriceNode {

    /**
     * 价格水平
     */
    private BigDecimal price;

    /**
     * 是否买
     */
    private Boolean isBid;

    /**
     * 每个PriceNode价格必定，先插入的订单就是首订单（消费撮合时候从这个首订单开始）
     */
    private Order firstOrder;

    private PriceNode prev;

    private PriceNode next;

    /**
     * 最后一个订单
     */
    private Order lastOrder;


    public PriceNode(BigDecimal price, Boolean isBid) {
        this.price = price;
        this.isBid = isBid;
    }

    /**
     * 添加订单到价格节点，同时维护订单链表  接受新订单时候触发
     * <p>往订单链表最后面添加</>
     *
     * @param newOrder
     * @return
     */
    public Boolean addOrder(Order newOrder) {
        Order lastOrder = this.lastOrder;
        //表示此价格节点还未有数据
        if (Objects.isNull(this.firstOrder)) {
            this.firstOrder = newOrder;
        }
        newOrder.setPrev(lastOrder);
        newOrder.setNext(null);
        newOrder.setPriceNode(this);
        this.lastOrder = newOrder;
        if (Objects.nonNull(lastOrder)) {
            lastOrder.setNext(newOrder);
        }
        return Boolean.TRUE;
    }


    /**
     * 价格节点删除订单-1、撮合成功后会删除  2、取消订单会删除
     *
     * @return
     */
    public Boolean removeOrder(Order removeOrder) {
        Order prev = removeOrder.getPrev();
        Order next = removeOrder.getNext();
        Order firstOrder = this.firstOrder;
        Order lastOrder = this.lastOrder;
        //移除该PriceNode上首个订单
        if (removeOrder.equals(firstOrder)) {
            //该节点后面的订单设置为首订单
            if (Objects.nonNull(next)) {
                next.setPrev(null);
                next.setPriceNode(this);
            }
            this.firstOrder = next;
        } else if (removeOrder.equals(lastOrder)) {
            //移除该PriceNode上最后一个订单
            //该节点前面的订单设置为最后一个订单
            if (Objects.nonNull(prev)) {
                prev.setNext(null);
            }
            this.lastOrder = prev;
        } else {
            //移除的订单为订单列表的中间订单
            if (Objects.nonNull(next)) {
                next.setPriceNode(this);
                next.setPrev(prev);
            }
            prev.setNext(next);

        }
        removeOrder.setPrev(null);
        removeOrder.setNext(null);
        return Boolean.TRUE;
    }

}
