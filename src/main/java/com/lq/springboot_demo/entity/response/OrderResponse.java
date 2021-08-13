package com.lq.springboot_demo.entity.response;

import com.lq.springboot_demo.entity.eunm.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {

    private String id;

    //是否删除

    private Boolean isDelete=false;

    private Date createTime;


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


    /**
     * 产品id
     */
    private String productId;


    private String productName;

    private String standardValues;


}
