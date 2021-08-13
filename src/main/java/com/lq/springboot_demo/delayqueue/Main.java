package com.lq.springboot_demo.delayqueue;

import java.util.concurrent.DelayQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayTask> tasks = new DelayQueue<>();
        long cur = System.currentTimeMillis();
        long[] delay = {15000L, 10000L, 5000L, 20000L};
        for (int i = 0; i < delay.length; i++) {
            DelayTask task = new DelayTask(delay[i] + cur, i);
            tasks.add(task);
        }
        while (!tasks.isEmpty()) {
            DelayTask peek = tasks.take();
            if (peek != null) {
                tasks.poll();
                System.out.println("时间间隔:"+ (System.currentTimeMillis() - cur) + "ms");
                System.out.println("当前任务序号：" + peek.index);
                cur = System.currentTimeMillis();
            }
            Thread.sleep(1000);
        }
    }
}

