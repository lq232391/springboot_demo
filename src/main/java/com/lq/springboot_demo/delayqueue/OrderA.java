package com.lq.springboot_demo.delayqueue;

import lombok.Data;

/**
 * 订单实体类
 * @author James Lee
 *
 */
@Data
public class OrderA {
    // 订单编号
    private String OrderId;
    // 订单金额
    private Double OrderMoney;
    // 省略get、set等方法

}