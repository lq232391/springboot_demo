package com.lq.springboot_demo.entity.eunm;

import lombok.Getter;

/**
 * 消息队列枚举配置
 * Created by macro on 2018/9/14.
 */
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_Order_CANCEL("mall.Order.direct", "mall.Order.cancel", "mall.Order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_Order_CANCEL("mall.Order.direct.ttl", "mall.Order.cancel.ttl", "mall.Order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}

