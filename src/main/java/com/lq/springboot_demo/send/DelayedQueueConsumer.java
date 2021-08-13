package com.lq.springboot_demo.send;

import com.lq.springboot_demo.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 延时队列消费者
 */
@Component
@Slf4j
public class DelayedQueueConsumer {

    //监听消息
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void  receiverDelayQueue(Message message){
        String msg=new String(message.getBody());
        log.info("当前的时间为:{},收到的延时消息为：{}",new Date().toString(),msg);
    }
}
