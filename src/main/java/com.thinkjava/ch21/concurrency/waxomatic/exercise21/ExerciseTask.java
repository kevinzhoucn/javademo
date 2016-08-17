//: com.thinkjava.ch21.concurrency.waxomatic.exercise21/ExerciseTask.java

package com.thinkjava.ch21.concurrency.waxomatic.exercise21;

/**
 * Exercise 21 一个任务启动调用wait() 另一个任务持有第一个任务的引用
 * 一定秒数后 为第一个任务调用 notifyAll() 唤醒第一个任务 打印一条信息
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-21
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.thinkjava.ch21.concurrency.ITask;

@Component("exerciseTask")
public class ExerciseTask implements ITask {
    // @Autowired
    private Task01 task01;

    // @Autowired
    private Task02 task02;

    @Override
    public void runTask() {
        System.out.println("====== ExerciseTask: Start ======");
        task01 = new Task01();
        task02 = new Task02(task01);
        
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(task01);
        exec.execute(task02);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();
        System.out.println("====== ExerciseTask: End ======");
    }
}
