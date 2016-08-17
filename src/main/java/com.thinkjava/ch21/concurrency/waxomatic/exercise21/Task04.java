//: com.thinkjava.ch21.waxomatic.exercise21/Task04.java

package com.thinkjava.ch21.concurrency.waxomatic.exercise21;

/**
 * Exercise22 忙等待的示例 第一个任务休眠一段时间后将一个标志位设置为true
 * 第二个任务在一个while循环中观察这个标志 标志变为true时 将其设置为false
 * 向控制台报告变化 计算在忙等待中浪费了多少时间
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-22
 */

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// @Component("exercise22Task04")
public class Task04 implements Runnable {
    
    // @Autowired
    // @Qualifier("exercise22Task03")
    private Task03 task03;

    public Task04(Task03 task03) {
        this.task03 = task03;
    }

    @Override
    public void run() {
        System.out.println("====== Sir, running from task04! ======");
        long startTime = System.currentTimeMillis();
        while(!Thread.interrupted()) {
            if(task03.getFlag()) {
                System.out.println("====== Sir, running from task04 flag trigger to true! ======");
                System.out.println("====== Will set it to false! ======");
                task03.disableFlag();
                long endTime = System.currentTimeMillis();
                long duringTime = endTime - startTime;
                System.out.println("====== Thread wait for: " + duringTime + " ======");
            }
        }
    }
}