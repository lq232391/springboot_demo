package com.lq.springboot_demo.delayqueue;


import java.util.Timer;

public class MyTimeout implements Timeout {
    Timer timer;
    TimerTask timerTask;
    String argv;
    long delay;
    int state;
    long round;

    public MyTimeout(Timer timer, TimerTask task, long delay, String argv) {
        this.timer = timer;
        this.timerTask = task;
        this.delay = delay;
        this.argv = argv;
        state = 0;
    }
    @Override
    public Timer timer() {
        return timer;
    }

    @Override
    public TimerTask task() {
        return timerTask;
    }

    @Override
    public boolean isExpired() {
        return state != 0;
    }
}

