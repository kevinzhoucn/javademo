//: com.thinkjava.ch21.concurrency.restaurant/Restaurant.java

package com.thinkjava.ch21.concurrency.restaurant;
/**
 * ===Start
 * Restaurant 持有 chef waitPerson meal
 * Restaurant 维护一个任务管理器 负责启动 chef waitPerson 和终止
 * End===
 *
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-24
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Restaurant {
    @Autowired
    public WaitPerson waitPerson;

    @Autowired
    public Chef chef;

    private ExecutorService exec;

    public Meal meal = null;

    public void startTask() {
        exec = Executors.newCachedThreadPool();
        exec.execute(waitPerson);
        exec.execute(chef);
    }

    public void shutdownTask() {
        exec.shutdownNow();
    }
}