/*
import com.lq.springboot_demo.delayqueue.ItemVo;
import com.lq.springboot_demo.entity.Order;

import java.util.concurrent.DelayQueue;

*/
/**
 * 模拟订单插入的功能
 *//*

public class PutOrder implements Runnable {

    // 使用DelayQueue：一个使用优先级队列实现的无界阻塞队列。
    private DelayQueue<ItemVo<Order>> queue;

    public PutOrder(DelayQueue<ItemVo<Order>> queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        */
/**
         * 这里模拟淘宝、京东、苏宁的订单，淘宝是5秒到期，京东是10秒到期，苏宁是15秒到期
         *//*

        // 淘宝订单插入
        Order tbOrder = new Order("tb001", 9.9);
        ItemVo<Order> itemVoTb = new ItemVo<Order>(5000, tbOrder);
        queue.offer(itemVoTb);
        System.out.println("淘宝订单5秒后过期：" + tbOrder.getOrderId());

        // 京东订单插入
        Order jdOrder = new Order("jd002", 19.9);
        ItemVo<Order> itemVoJd = new ItemVo<Order>(10000, jdOrder);
        queue.offer(itemVoJd);
        System.out.println("京东订单10秒后过期：" + jdOrder.getOrderId());

        // 苏宁订单插入
        Order snOrder = new Order("sn003", 29.9);
        ItemVo<Order> itemVoSn = new ItemVo<Order>(15000, snOrder);
        queue.offer(itemVoSn);
        System.out.println("苏宁订单15秒后过期：" + tbOrder.getOrderId());

    }
}*/
