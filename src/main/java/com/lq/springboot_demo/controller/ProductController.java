package com.lq.springboot_demo.controller;


import com.lq.springboot_demo.entity.Order;
import com.lq.springboot_demo.entity.Product;
import com.lq.springboot_demo.entity.request.ProductRequest;
import com.lq.springboot_demo.entity.request.UpdateProductRequest;
import com.lq.springboot_demo.mapper.OrderMapper;
import com.lq.springboot_demo.mapper.ProduceMapper;
import com.lq.springboot_demo.service.ProductService;
import com.lq.springboot_demo.util.RandomUtils;
import com.lq.springboot_demo.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Api(value = "/product", tags = {"产品管理"})
@Component//监听的队列名称 TestDirectQueue
public class ProductController {
    @Resource
    private OrderMapper OrderMapper;

    @Resource
    private ProductService productService;
    @Resource
    private ProduceMapper produceMapper;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/add")
    @ApiModelProperty("创建产品")
    public String insertProduct(ProductRequest request){

        return productService.insertProduct(request);

    }
    @GetMapping("/selectByUserId")
    @ApiModelProperty("查询一个用户下有几个产品")
    public List<Product> queryByUserId(String userId){

        return productService.queryByUserId(userId);
    }
    @PutMapping("/update")
    public String updateProduct(UpdateProductRequest request){

        return productService.updateProduct(request);
    }
    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void process(Map map){
        System.out.println("接受到的消息为"+map.toString());
       List< String> productId = (List<String>) map.get("productId");
        for (String s : productId) {
            Product product = produceMapper.queryById(s);
            if(product.getCount()!=0) {
                int count = product.getCount();
                product.setCount(count-1);
            }
            produceMapper.updateCount(product);

        }

    }
    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void redisMq(Map map){
        String OrderId = (String) map.get("OrderId");
        Order Order = OrderMapper.selectById(OrderId);
        redisUtil.set("Order"+ RandomUtils.getRandomStr(4),Order);
    }
}
