package com.tu.demo_s_mp.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2021/1/29 0029.
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        airConditioner.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "加一线程1 ").start();

            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        airConditioner.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "减一线程1 ").start();
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        airConditioner.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "加一线程2 ").start();

            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        airConditioner.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "减一线程2 ").start();

    }
}
// 资源类
class AirConditioner{
    private int number = 0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        // 判断
        if(number != 0) {
            condition.await();
        }
        // 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        condition.signal();
        lock.unlock();
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        // 判断
        if (number == 0) {
            condition.await();
        }
        // 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 通知
        condition.signal();
        lock.unlock();
    }

}