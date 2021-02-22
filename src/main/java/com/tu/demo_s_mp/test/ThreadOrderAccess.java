package com.tu.demo_s_mp.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2021/1/29 0029.
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {

        ShareResource resource=new ShareResource();

        for (int i=0;i<10;i++){
            new Thread(()->{
                try {
                    resource.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"ThreadA").start();

            new Thread(()->{
                try {
                    resource.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"ThreadB").start();

            new Thread(()->{
                try {
                    resource.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"ThreadC").start();
        }
    }

}
class ShareResource {
    private int number=1;
    private Lock lock=new ReentrantLock();
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();
    private Condition conditionC=lock.newCondition();


    public void print5() throws InterruptedException {
        lock.lock();
        try {
            while(number!=1){
                conditionA.await();
            }
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName() + "\t" + (i + 1) +"AA");
            }
            number=2;
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try {
            while (number!=2){
                conditionB.await();
            }
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + "\t" + (i + 1) +"BB");
            }
            number=3;
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try {
            while (number!=3){
                conditionC.await();
            }
            for(int i=0;i<15;i++){
                System.out.println(Thread.currentThread().getName() + "\t" + (i + 1) +"CC");
            }
            number=1;
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }
}