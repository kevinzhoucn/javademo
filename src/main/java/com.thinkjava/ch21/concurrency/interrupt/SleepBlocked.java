//: com.thinkjava.ch21.interrupt/SleepBlocked.java

package com.thinkjava.ch21.concurrency.interrupt;

/**
 * Interrupting a blocked thread
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-19
 */

import java.util.concurrent.*;
import java.io.*;
import org.springframework.stereotype.Component;

@Component("sleepBlocked")
public class SleepBlocked implements Runnable {
    /**
     * 重载 run 方法 模拟线程阻塞现象
     */
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);            
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception!");
        }
        System.out.println("Exiting SleepBlocked run()!");
    }
} ///:~