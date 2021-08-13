package com.lq.springboot_demo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

@EqualsAndHashCode
@Data
@Table(name = "t_order_product")
public class OrderProduct {

    private String id;

    private String OrderId;

    private String productId;

    private Date createTime;
}
