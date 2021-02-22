package com.tu.demo_s_mp.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2021/1/28 0028.
 */
public class VolatileTest {

    public static AtomicInteger race = new AtomicInteger();

    private static final int THREADS_COUNT = 20;

    private static CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);

    public static void increase() {
        race.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                    countDownLatch.countDown();
                }
            });
            threads[i].start();
        }
        countDownLatch.await();
        System.out.println(race);
    }

}
