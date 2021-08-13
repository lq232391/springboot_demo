package com.lq.springboot_demo.controller;

import com.lq.springboot_demo.entity.Order;
import com.lq.springboot_demo.entity.Product;
import com.lq.springboot_demo.entity.eunm.OrderStatus;
import com.lq.springboot_demo.entity.request.AddOrderRequest;
import com.lq.springboot_demo.entity.response.OrderResponse;
import com.lq.springboot_demo.mapper.OrderMapper;
import com.lq.springboot_demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Order")
@RequiredArgsConstructor
@Api(value = "/Order", tags = {"订单管理"})
public class OrderController {

    @Resource
    private OrderService OrderService;
    @Resource
    private OrderMapper OrderMapper;

    @PostMapping("/add")
    @ApiModelProperty("创建订单")
    public String addOrder(AddOrderRequest request){
        return OrderService.addOrder(request);
    }
    @GetMapping("/queryByUserId")
    @ApiModelProperty("根据用户查询订单")
    public List<OrderResponse> queryByUserId(String userId){

        return OrderService.queryByUserId(userId);
    }
    @PostMapping("/pay")
    public String pay(String OrderId){
        Order Order = OrderMapper.selectById(OrderId);
        Order.setOrderStatus(OrderStatus.PAID);
        OrderMapper.updateStatus(OrderId);
        return "支付成功";
    }
}
