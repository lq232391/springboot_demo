package com.lq.springboot_demo.delayqueue;

import java.util.Timer;

public interface Timeout {
    Timer timer();
    TimerTask task();
    boolean isExpired();
}
