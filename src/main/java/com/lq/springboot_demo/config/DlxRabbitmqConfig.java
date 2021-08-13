/*
package com.lq.springboot_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DlxRabbitmqConfig {
    //====================1.声明正常队列====================
    @Bean
    public DirectExchange OrderExchange(){
        return new DirectExchange("springboot.OrderExchange", true, false);
    }

    @Bean
    public Queue OrderQueue(){
        Map<String, Object> queueArgs = new HashMap<>();
        //10秒中后消息过期
        queueArgs.put("x-message-ttl",10000);
        //过期后，将消息转发给"springboot.OrderDlxExchange"交换机
        queueArgs.put("x-dead-letter-exchange","springboot.OrderDlxExchange");

        return new Queue("springboot.OrderQueue",true,false,false,queueArgs);
    }

    @Bean
    public Binding OrderBinding(){
        return BindingBuilder.bind(OrderQueue()).to(OrderExchange()).with("Order.key");
    }

    //====================2.声明死信队列====================
    @Bean
    public DirectExchange OrderDlxExchange(){
        return new DirectExchange("springboot.OrderDlxExchange",true,false);
    }

    @Bean
    public Queue OrderDlxQueue(){
        return new Queue("springboot.OrderDlxQueue",true,false,false);
    }

    @Bean
    public Binding dlxBinding(){
        return BindingBuilder.bind(OrderDlxQueue()).to(OrderDlxExchange()).with("Order.key");
    }
}
*/
