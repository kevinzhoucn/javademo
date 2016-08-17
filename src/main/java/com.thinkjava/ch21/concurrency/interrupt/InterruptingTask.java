//: com.thinkjava.ch21.concurrency.interrupt/InterruptingTask.java

package com.thinkjava.ch21.concurrency.interrupt;

/**
 * Interrupt 的测试程序 测试三个阻塞线程的中断情况
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.thinkjava.ch21.concurrency.ITask;

@Component("interruptingTask")
public class InterruptingTask implements ITask {
    @Autowired
    @Qualifier("ioblocked")
    private Runnable ioblocked;

    @Autowired
    @Qualifier("sleepBlocked")
    private Runnable sleepBlocked;

    @Autowired
    @Qualifier("synchronizedBlocked")
    private Runnable synchronizedBlocked;

    private ExecutorService exec;

    public InterruptingTask() {
        exec = Executors.newCachedThreadPool();
    }

    @Override
    public void runTask() {
        System.out.println("Interrupting Task: Start");
        
        try {
            // testTask(ioblocked);
            // testTask(sleepBlocked);
            // testTask(synchronizedBlocked);
            testTask(new IOBlocked(System.in));
            // testTask(new SleepBlocked());
            // testTask(new SynchronizedBlocked());

            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupting Task: End");
    }

    private void testTask(Runnable task) throws InterruptedException {
        Future<?> f = exec.submit(task);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + task.getClass().getName());
        f.cancel(true);
        System.out.println("interrupt send to " + task.getClass().getName());
    }
}
