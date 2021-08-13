package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.request.AddOrderRequest;
import com.lq.springboot_demo.entity.response.OrderResponse;

import java.util.List;

public interface OrderService {

String addOrder(AddOrderRequest request);

    /**
     * 根据用户id查询订单
     * @param userId
     * @return
     */
    List<OrderResponse> queryByUserId(String userId);
}
