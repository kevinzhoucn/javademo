//: com.thinkjava.ch21.concurrency.waxomatic/WaxOff.java

package com.thinkjava.ch21.concurrency.waxomatic;

/**
 * 抛光完毕状态
 * 抛光完毕 将waxOn设置为false 同时进入打蜡任务
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-20
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("waxOff")
public class WaxOff implements Runnable {
    @Autowired
    private Car car;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off!");

                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via Interrupted!");
        }
        System.out.println("Ending Wax Off task!");
    }
}///:~