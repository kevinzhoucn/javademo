//: com.thinkjava.ch21.waxomatic.exercise21/Task03.java

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
import java.util.concurrent.*;

// @Component("exercise22Task03")
public class Task03 implements Runnable {
    /**
     * Private field boolean flag
     */
    private volatile boolean flag = false;

    public boolean getFlag() {
        return flag;
    }

    public void enableFlag() {
        flag = true;
    }

    public void disableFlag() {
        flag = false;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                if(!this.getFlag()) {                    
                    System.out.println("====== Sir, Running from task03! ======");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("====== Sir, I will set flag to true! ======");
                    enableFlag();
                    // this.flag = true;
                    System.out.println("====== Sir, flag set to " + getFlag() + "! ======");
                }
            }
        } catch(InterruptedException e) {
            System.out.println("====== Sir, exiting from interrupted()! ======");
        }
    }
}