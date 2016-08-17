//: com.thinkjava.ch21.concurrency.waxomatic/WaxOn.java

package com.thinkjava.ch21.concurrency.waxomatic;

/**
 * 打蜡完毕状态
 * 打蜡完毕 将waxOn设置为true 同时进入抛光任务
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-20
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("waxOn")
public class WaxOn implements Runnable {
    @Autowired
    private Car car;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via Interrupted!");
        }
        System.out.println("Ending Wax On task!");
    }
} /* Output:
    花费一段时间打蜡 同时进入抛光等待状态
*///:~