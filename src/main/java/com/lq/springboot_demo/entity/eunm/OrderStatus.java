package com.lq.springboot_demo.entity.eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    CANCELED("已取消"),WAITING("待付款"),PAID("待发货"),RECEIPT("待收货"),OVER("已完成");

    private final String msg;
}
