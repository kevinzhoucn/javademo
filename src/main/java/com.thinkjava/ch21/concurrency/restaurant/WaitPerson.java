//: com.thinkjava.ch21.concurrency.restaurant/WaitPerson.java

package com.thinkjava.ch21.concurrency.restaurant;

/**
 * WaitPersoin类 属于一个restaurant
 * 获得自身锁 检查restaurant.meal是否为空 
 * 为空则挂起等待
 * 非空则将meal领走 同时设置meal为空状态 获得restaurant.chef锁 通知chef生产新的meal
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-23
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class WaitPerson implements Runnable {
    @Autowired
    private Restaurant restaurant;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null) {
                        wait();
                    }
                }

                System.out.println("Waitperson get: " + restaurant.meal);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }                
            }

        } catch(InterruptedException e) {
            System.out.println("Waitperson INTERRUPTED! ");
        }
    }
}///:~