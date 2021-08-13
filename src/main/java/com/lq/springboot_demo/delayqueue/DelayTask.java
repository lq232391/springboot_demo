package com.lq.springboot_demo.delayqueue;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.Delayed;

public class DelayTask implements Delayed {
    long dealAt;
    int index;
    public DelayTask(long time, int ix) {
        dealAt = time;
        index = ix;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(dealAt - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else {
            return -1;
        }
    }
}

