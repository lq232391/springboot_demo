package com.lq.springboot_demo.entity.request;

import com.lq.springboot_demo.entity.eunm.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AddOrderRequest {





    /**
     * 订单总价
     */

    private BigDecimal price;




    /**
     * 地址
     */

    private String addressId;


    /**
     * 手机
     */
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
    private List<String> productId;
}
