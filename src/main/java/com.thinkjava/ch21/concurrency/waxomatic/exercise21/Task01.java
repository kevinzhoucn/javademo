//: com.thinkjava.ch21.concurrency.waxomatic.exercise21/Task01.java

package com.thinkjava.ch21.concurrency.waxomatic.exercise21;

/**
 * Exercise 21 一个任务启动调用wait() 另一个任务持有第一个任务的引用
 * 一定秒数后 为第一个任务调用 notifyAll() 唤醒第一个任务 打印一条信息
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-21
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;

// @Component
public class Task01 implements Runnable {
    @Override
    public void run() {
        try {
            synchronized(this) {
                this.wait();
                System.out.println("====== Invoke from Task01, received signal! ======");
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // try {
        //     synchronized(this) {
        //         System.out.println("====== Sleep from Task01! ======");
        //         TimeUnit.SECONDS.sleep(2);
        //         this.notifyAll();
        //     }
        // } catch(InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
}