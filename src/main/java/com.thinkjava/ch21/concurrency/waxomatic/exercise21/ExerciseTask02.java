//: com.thinkjava.ch21.waxomatic.exercise21/ExerciseTask02.java

package com.thinkjava.ch21.concurrency.waxomatic.exercise21;

/**
 * Exercise22 忙等待的示例 第一个任务休眠一段时间后将一个标志位设置为true
 * 第二个任务在一个while循环中观察这个标志 标志变为true时 将其设置为false
 * 向控制台报告变化 计算在忙等待中浪费了多少时间
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-22
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.thinkjava.ch21.concurrency.ITask;

@Component("exerciseTask02")
public class ExerciseTask02 implements ITask {
    // @Autowired
    // @Qualifier("exercise22Task03")
    private Task03 task03;

    // @Autowired
    // @Qualifier("exercise22Task04")
    private Task04 task04;

    @Override
    public void runTask() {
        System.out.println("====== ExerciseTask02: Start ======");
        
        ExecutorService exec = Executors.newCachedThreadPool();
        this.task03 = new Task03();
        this.task04 = new Task04(task03);

        exec.execute(this.task03);
        exec.execute(this.task04);

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();
        System.out.println("====== ExerciseTask02: End ======");
    }
}