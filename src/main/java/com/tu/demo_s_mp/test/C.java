package com.tu.demo_s_mp.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2020/11/18 0018.
 */
public class C {
    /*public static void main(String[] args) {
        Executors.newFixedThreadPool(5,)
    }*/

    public static void fixTheadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName "+Thread.currentThread().getName()+" execuse  "+ii);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}


