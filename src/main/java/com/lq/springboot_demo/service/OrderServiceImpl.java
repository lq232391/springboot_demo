package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.Order;
import com.lq.springboot_demo.entity.OrderProduct;
import com.lq.springboot_demo.entity.eunm.OrderStatus;
import com.lq.springboot_demo.entity.request.AddOrderRequest;
import com.lq.springboot_demo.entity.response.OrderResponse;
import com.lq.springboot_demo.entity.response.ProductResponse;
import com.lq.springboot_demo.mapper.OrderMapper;
import com.lq.springboot_demo.mapper.OrderProductMapper;
import com.lq.springboot_demo.util.RandomUtils;
import com.lq.springboot_demo.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderMapper OrderMapper;
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private OrderProductMapper OrderProductMapper;

    @Override
    public String addOrder(AddOrderRequest request) {
        Order Order = new Order();
        Order.setUserId(request.getUserId());
        Order.setPrice(request.getPrice());
        Order.setAddressId(request.getAddressId());
        Order.setRemark(request.getRemark());
        Order.setOrderNum(RandomUtils.getRandomString(32));
        Order.setPhone(request.getPhone());
        Order.setCreateTime(new Date());
        Order.setId(RandomUtils.getRandomString(32));
        Order.setIsDelete(Boolean.FALSE);
        Order.setOrderStatus(OrderStatus.WAITING);
        OrderMapper.insert(Order);
        OrderProduct OrderProduct = new OrderProduct();

        List<String> productId = request.getProductId();

        for (String s : productId) {
            OrderProduct.setId(RandomUtils.getRandomString(32));
            OrderProduct.setProductId(s);
            OrderProduct.setCreateTime(new Date());
            OrderProduct.setOrderId(Order.getId());
            OrderProductMapper.insert(OrderProduct);
        }

        String s = OrderMapper.selectById(Order.getId()).toString();

        this.rabbitTemplate.convertAndSend("deom5Exchange", "keyDemo5", s, message -> {
            // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(1 * 1000 * 3 + "请在30s之内支付订单");
            return message;
        });
        HashMap<String, Object> map = new HashMap<>();
        map.put("OrderId",Order.getId());
        map.put("productId",request.getProductId());
        map.put("createTime",new Date());
        rabbitTemplate.convertAndSend("fanoutExchange",null,map);
        return "添加成功";
    }

    @Override
    public List<OrderResponse> queryByUserId(String userId) {
        List<OrderResponse> OrderResponses = OrderMapper.queryByUserId(userId);


        return OrderResponses;
    }
}
