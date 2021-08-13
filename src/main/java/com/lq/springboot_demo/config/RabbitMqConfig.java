package com.lq.springboot_demo.config;


import com.lq.springboot_demo.entity.eunm.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列配置
 * Created by macro on 2018/9/14.
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 订单消息实际消费队列所绑定的交换机
     */
    @Bean
    DirectExchange OrderDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_Order_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单延迟队列队列所绑定的交换机
     */
    @Bean
    DirectExchange OrderTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TTL_Order_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单实际消费队列
     */
    @Bean
    public Queue OrderQueue() {
        return new Queue(QueueEnum.QUEUE_Order_CANCEL.getName());
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue OrderTtlQueue() {
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_Order_CANCEL.getName())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_Order_CANCEL.getExchange())//到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_Order_CANCEL.getRouteKey())//到期后转发的路由键
                .build();
    }

    /**
     * 将订单队列绑定到交换机
     */
    @Bean
    Binding OrderBinding(DirectExchange OrderDirect,Queue OrderQueue){
        return BindingBuilder
                .bind(OrderQueue)
                .to(OrderDirect)
                .with(QueueEnum.QUEUE_Order_CANCEL.getRouteKey());
    }

    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    Binding OrderTtlBinding(DirectExchange OrderTtlDirect,Queue OrderTtlQueue){
        return BindingBuilder
                .bind(OrderTtlQueue)
                .to(OrderTtlDirect)
                .with(QueueEnum.QUEUE_TTL_Order_CANCEL.getRouteKey());
    }

}
