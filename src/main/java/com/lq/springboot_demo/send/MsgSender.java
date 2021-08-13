package com.lq.springboot_demo.send;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class MsgSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //利用插件发送延迟消息
    public void sendDelayMsg(Object Order , Map<String,Object> msgProp) throws JsonProcessingException {
        //1. 构建消息头
        MessageHeaders messageHeaders = new MessageHeaders(msgProp);

        //2. 设置消息转换器
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

        //3. 构建correlationData 用于做可靠性投递得,ID:必须为全局唯一的 根据业务规则
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

        //4. 开启确认模式
        rabbitTemplate.setConfirmCallback(null);

        //5. 开启消息可达监听
        rabbitTemplate.setReturnCallback(null);

        //6. 发送消息(这里是关键)
        rabbitTemplate.convertAndSend("OrderDelayExchange", "Order.key",Order, new MessagePostProcessor() {
            @Override
            public org.springframework.amqp.core.Message postProcessMessage(org.springframework.amqp.core.Message message) throws AmqpException {
                message.getMessageProperties().setDelay(5000);  //设置延迟时间
                return message;
            }
        },correlationData);
    }
}
