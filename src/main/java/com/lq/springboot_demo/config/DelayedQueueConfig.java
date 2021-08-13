package com.lq.springboot_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class DelayedQueueConfig {
    //交换机
    public static final String DELAYED_EXCHANGE_NAME = "delayed.exchange";

    //队列
    public static final String DELAYED_QUEUE_NAME = "delayed.queue";

    //routingKey
    public static final String  DELAYED_ROUTING_KEY="delayed_routingKey";

    //队列
    @Bean
    public Queue delayedQueue(){
        return  new Queue(DELAYED_QUEUE_NAME);
    }
    //声明交换机
    @Bean
    public CustomExchange delayedExchange(){

        Map<String, Object> arguments=new HashMap<>();
        /**
         * 1.交换机名称  2.交换机的类型 3.是否需要持久化 4.是否需要自删除 5.map<其余的函数>
         */
        arguments.put("x-delayed-message","direct");

        return new  CustomExchange(DELAYED_EXCHANGE_NAME,"x-delayed-message",true,false,arguments);
    }
    //绑定
    @Bean
    public Binding delayedQueueBindingExchange(
            @Qualifier("delayedQueue") Queue DELAYED_QUEUE_NAME,
            @Qualifier("delayedExchange") CustomExchange DELAYED_EXCHANGE_NAME
    ){
        return BindingBuilder.bind(delayedQueue()).to(delayedExchange()).with(DELAYED_ROUTING_KEY).noargs();
    }
}
