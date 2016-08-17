//: com.thinkjava.ch21.cocurrency.waxomatic/Car.java

package com.thinkjava.ch21.concurrency.waxomatic;

/**
 * 汽车类 打蜡 抛光 操作的对象汽车类
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-20
 */

import org.springframework.stereotype.Component;

@Component("car")
public class Car {
    /**
     * 打蜡状态 初始值false
     * 需要同步的临界值 设置为私有变量 外界不可见
     */
    private boolean waxOn = false;

    /**
     * 同步方法 打蜡完毕
     * 设置状态 布尔操作 原子操作
     * 同时向抛光任务发送信号
     */
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    /**
     * 同步方法 抛光完毕
     * 同时向打蜡任务发送信号
     */
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    /**
     * 同步方法 等待打蜡
     * 调用 wait() 将任务挂起
     * 等待 notify() 信号
     */
    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn == false) {
            wait();
        }
    }

    /**
     * 同步方法 等待抛光
     * 调用 wait() 将任务挂起
     * 等待 notify() 信号
     */
    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn == true) {
            wait();
        }
    }
}