//: com.thinkjava.ch21.cocurrency.waxomatic/WaxOMatic.java

package com.thinkjava.ch21.concurrency.waxomatic;

/**
 * 一个基本的线程协同例子 模拟汽车抛光操作
 * 一个线程给汽车涂蜡 另一个线程给汽车抛光 协同工作
 * 涂蜡后才能给汽车抛光 抛光后才能再次涂蜡
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-20
 */

import java.util.concurrent.*;
import com.thinkjava.ch21.concurrency.ITask;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component("waxOMatic")
public class WaxOMatic implements ITask {
    @Autowired
    @Qualifier("waxOn")
    private Runnable waxOn;

    @Autowired
    @Qualifier("waxOff")
    private Runnable waxOff;

    @Override
    public void runTask() {
        System.out.println("WaxOMatic task: start------");
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(waxOn);
        exec.execute(waxOff);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();
        System.out.println("------WaxOMatic task: end");
    }
} /* Output: (95% match)
     Wax On! Wax Off! ............
*///:~