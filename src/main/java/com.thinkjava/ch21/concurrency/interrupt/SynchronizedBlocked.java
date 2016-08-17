//: com.thinkjava.ch21.concurrency.interrupt/SynchronizedBlocked.java

package com.thinkjava.ch21.concurrency.interrupt;

/**
 * 模拟一个死锁状态
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-19
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;

@Component("synchronizedBlocked")
public class SynchronizedBlocked implements Runnable {
    /**
     * 同步方法加锁 永远不会停止
     */
    public synchronized void f() {
        while(true) {
            Thread.yield();
        }
    }

    /**
     * 构造函数启动线程占有锁
     */
    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }

    /**
     * 重载 run() 方法来尝试运行获得锁
     */
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
