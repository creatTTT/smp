package com.tu.demo_s_mp.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2021/1/29 0029.
 */
public class SaleTicket {
    public static void main(String[] args) {
        // 资源类
        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i <= 30 ; i++) {ticket.saleTicket();}
        },"售票员A").start();
        new Thread(()->{
            for (int i = 0; i <= 30 ; i++) {ticket.saleTicket();}
        },"售票员B").start();
        new Thread(()->{
            for (int i = 0; i <= 30 ; i++) {ticket.saleTicket();}
        },"售票员C").start();


    }
}
class Ticket {
    private int number = 30;
    private Lock lock=new ReentrantLock();
    // 操作
    public void saleTicket(){
        lock.lock();
        try {
            if(number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第" + (number--) + "\t 还剩下:" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}