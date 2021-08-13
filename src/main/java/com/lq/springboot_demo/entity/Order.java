package com.lq.springboot_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lq.springboot_demo.entity.eunm.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@EqualsAndHashCode
@Data
@Table(name = "t_order")
public class Order extends BaseEntity{

    /**
     * 内部订单号
     */

    private String OrderNum;

    /**
     * 订单状态
     */

    private OrderStatus OrderStatus;

    /**
     * 订单总价
     */

    private BigDecimal price;




    /**
     * 地址
     */

    private String addressId;




    private String phone;



    /**
     * 订单备注
     */

    private String remark;



    /**
     * 订单所属用户
     */
    private String userId;



}
