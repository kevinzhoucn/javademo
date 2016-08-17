//: com.thinkjava.ch21.concurrency.waxomatic.exercise21/Task02.java

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
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Task02 implements Runnable {
    @Autowired
    private Task01 task01;

    @Override
    public void run() {
        System.out.println("====== Waiting from task02! ======");
        synchronized(task01) {
            try {
                TimeUnit.SECONDS.sleep(2);                
            } catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                task01.notifyAll();
            }
        }
    }
}