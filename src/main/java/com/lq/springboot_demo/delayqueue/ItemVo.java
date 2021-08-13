package com.lq.springboot_demo.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
/**
 * 存到队列里的元素
 * 支持延时获取的元素的阻塞队列，元素必须要实现Delayed接口。
 * 根据订单有效时间作为队列的优先级
 * @param <T>
 */
public class ItemVo<T> implements Delayed{
    // 到期时间 单位：ms
    private long activeTime;
    // 订单实体（使用泛型是因为后续扩展其他业务共用此业务类）
    private T data;

    public ItemVo(long activeTime, T data) {
        super();
        // 将传入的时间转换为超时的时刻
        this.activeTime = TimeUnit.NANOSECONDS.convert(activeTime, TimeUnit.MILLISECONDS)
                + System.nanoTime();
        this.data = data;
    }

    public long getActiveTime() {
        return activeTime;
    }
    public T getData() {
        return data;
    }

    // 按照剩余时间进行排序
    @Override
    public int compareTo(Delayed o) {
        // 订单剩余时间-当前传入的时间= 实际剩余时间（单位纳秒）
        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        // 根据剩余时间判断等于0 返回1 不等于0
        // 有可能大于0 有可能小于0  大于0返回1  小于返回-1
        return (d == 0) ? 0 : ((d > 0) ? 1 : -1);
    }

    // 获取剩余时间
    @Override
    public long getDelay(TimeUnit unit) {
        // 剩余时间= 到期时间-当前系统时间，系统一般是纳秒级的，所以这里做一次转换
        long d = unit.convert(activeTime-System.nanoTime(), TimeUnit.NANOSECONDS);
        return d;
    }

}