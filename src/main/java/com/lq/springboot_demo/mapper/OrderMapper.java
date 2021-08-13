package com.lq.springboot_demo.mapper;

import com.lq.springboot_demo.entity.Order;
import com.lq.springboot_demo.entity.Product;
import com.lq.springboot_demo.entity.request.AddOrderRequest;
import com.lq.springboot_demo.entity.response.OrderResponse;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


@Repository
public interface OrderMapper extends BaseMapper<Order> {

    void addOrder(AddOrderRequest request);

    Order selectById(String id);


    /**
     * 根据用户id查询订单
     *
     * @param userId
     */
    List<OrderResponse> queryByUserId(String userId);


    Product queryByAId(String OrderId);

    /**
     * 修改订单状态
     * @param OrderId
     */
    void updateStatus(String OrderId);


}
