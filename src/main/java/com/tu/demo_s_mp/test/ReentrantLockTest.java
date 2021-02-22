package com.tu.demo_s_mp.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2021/1/28 0028.
 */
public class ReentrantLockTest {

    private static final Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        /*new Thread(()->test(),"线程A").start();
        new Thread(()->test(),"线程B").start();
        new Thread(()->test(),"线程C").start();
        new Thread(()->test(),"线程D").start();
        new Thread(()->test(),"线程E").start();*/
        for(int i=0;i<5;i++){
            new Thread(new ThreadDemo(i)).start();
        }

    }

    public static void test(){
        for (int i=0;i<2;i++){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"释放锁");
            }
        }

    }

    static class ThreadDemo implements Runnable {
        Integer id;
        public ThreadDemo(Integer id) {
            this.id = id;
        }
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<2;i++){
                lock.lock();
                System.out.println("获得锁的线程："+id);
                lock.unlock();
            }
        }
    }
}
