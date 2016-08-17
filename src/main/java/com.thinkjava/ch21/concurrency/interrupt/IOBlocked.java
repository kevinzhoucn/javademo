//: com.thinkjava.ch21.concurrency.interrupt/IOBlocked.java

package com.thinkjava.ch21.concurrency.interrupt;

/**
 * 模拟 IO 输入等待 阻塞线程
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-19
 */

import java.util.concurrent.*;
import java.io.*;
import org.springframework.stereotype.Component;

@Component("ioblocked")
public class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked() { this.in = System.in; }
    public IOBlocked(InputStream is) { this.in = is; }

    public void run() {
        try {
            System.out.println("Waiting for read(): ");
            in.read();
        } catch(IOException e) {
        //     e.printStackTrace();
        // } catch (InterruptedException e) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked run()!");
    }
} ///:~