package com.lq.springboot_demo.delayqueue;


import com.lq.springboot_demo.entity.Order;

import java.util.concurrent.DelayQueue;
/**
 * 取出到期的订单的功能
 */
class FetchOrder implements Runnable{

    // 使用DelayQueue：一个使用优先级队列实现的无界阻塞队列。
    private DelayQueue<ItemVo<Order>> queue;

    public FetchOrder(DelayQueue<ItemVo<Order>> queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                // 使用DelayQueue的take方法获取当前队列里的元素(take方法是阻塞方法，如果队列里有值则取出，否则一直阻塞)
                ItemVo<Order> itemVo = queue.take();
                // 获取元素的实体对象，保险起见做一次强制转型
                Order Order = (Order)itemVo.getData();
                System.out.println("订单："+ " 已过期！已从订单队列里剔除！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}