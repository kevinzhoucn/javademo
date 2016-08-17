//: com.thinkjava.ch21.concurrency.garden/EntranceTask.java
package com.thinkjava.ch21.concurrency.garden;

/**
 * 模拟公园入口的任务
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-18
 */

import java.util.concurrent.*;
import java.util.*;
import com.thinkjava.ch21.concurrency.ITask;
import org.springframework.stereotype.Component;

@Component("entranceTask")
public class EntranceTask implements ITask {

    @Override
    public void runTask() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++) {
            exec.execute(new Entrance(i));
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        Entrance.cancel();
        exec.shutdown();
        try {
            if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
                System.out.println("Some task not terminated!");
            } else {
                System.out.println("All task terminated!");
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrance: " + Entrance.sumEntrances());
    }
}