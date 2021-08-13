/*
package com.lq.springboot_demo.delayqueue

import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TimeWheel implements Timer {
    long basicTime;
    List<Timeout> timeoutList;
    CountDownLatch countDownLatch;
    Worker woker = new Worker();
    int wheelState = 1; // 0 运行 1 停止
    int curIndex;
    int size;
    int mask;
    long durationOfSlot;
    LinkedList<Timeout>[] slots;
    ArrayList<TimerTask> res = new ArrayList<>();

    TimeWheel(int size, long durationOfSlot) throws Exception{
        if (size < 0 || size > Integer.MAX_VALUE) {
            throw new Exception("size out of range");
        }
        this.size = size;
        slots = new LinkedList[size];
        this.durationOfSlot = durationOfSlot;
        mask = size - 1;
        curIndex = 0;
        basicTime = 0;
        timeoutList = new ArrayList<>();
        countDownLatch = new CountDownLatch(1);
    }

    @Override
    public Timeout newTimeOut(TimerTask task, long delay, String argv) {
        if(delay <= 0) {
            try {
                task.run();
            } catch (Exception e) {
                System.out.println("delay is less than zero, just run");
            }
        }
        if (wheelState == 1) {
            wheelState = 0;
            Thread thread = new Thread(woker);
            thread.start();

        }
        startTimeWheel();
        Timeout timeout = new MyTimeout(this, task, delay, argv);
        timeoutList.add(timeout);
        return timeout;
    }

    private void startTimeWheel() {
        while (basicTime == 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                System.out.println("countdown await exception");
            }
        }
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            if (basicTime == 0) {
                System.out.println("时间轮启动......");
                basicTime = Instant.now().toEpochMilli();
                countDownLatch.countDown();
            }
            do {
                long deadline = durationOfSlot * (curIndex + 1);
                for (;;) {
                    //System.out.println(basicTime+"basc");
                    long duration = Instant.now().toEpochMilli() - basicTime;
                    //System.out.println(deadline +"   " + duration);
                    if (duration > deadline) {
                        //时间到
                        process(timeoutList);
                        LinkedList<Timeout> tasks = slots[curIndex];
                        process(tasks);
                        break;
                    }
                }
                if (curIndex == mask) {
                    basicTime = System.currentTimeMillis();
                }
                curIndex = (++curIndex) % size;
                checkStop();
            } while (wheelState == 0);
        }

        private void checkStop() {
            if (!CollectionUtils.isEmpty(timeoutList)) {
                return;
            }
            for (LinkedList l : slots) {
                if (!CollectionUtils.isEmpty(l)) {
                    return;
                }
            }
            System.out.println("没有定时任务，结束");
            wheelState = 1;
        }

        private void process(List<Timeout> timeoutList) {
            //System.out.println("处理新加入的任务");
            for (Timeout out : timeoutList) {
                MyTimeout mo = (MyTimeout) out;
                if (mo.isExpired()) {
                    continue;
                }
                long needskipslots = mo.delay / durationOfSlot;
                mo.round = (needskipslots - curIndex) / size;
                int index = (int)(needskipslots) % size;
                int i = (index + curIndex) % size;
                LinkedList<Timeout> slot = slots[i];
                if (slot == null) {
                    slot = new LinkedList<>();
                }
                slot.add(mo);
                slots[(index + curIndex) % size] = slot;
            }
            timeoutList.clear();
        }

        void process(LinkedList<Timeout> outs) {
            //System.out.println("处理到期任务");
            if (CollectionUtils.isEmpty(outs)) {
                return;
            }
            Iterator<Timeout> iterator = outs.iterator();
            while (iterator.hasNext()) {
                Timeout next = iterator.next();
                try {
                    MyTimeout mo = (MyTimeout) next;
                    if (mo.round > 0) {
                        mo.round --;
                        continue;
                    }
                    mo.task().run();
                    res.add(mo.task());
                    iterator.remove();
                    System.out.println("-************************************");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }


}

*/
