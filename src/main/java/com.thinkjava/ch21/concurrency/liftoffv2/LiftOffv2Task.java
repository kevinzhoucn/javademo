//: com.thinkjava.ch21.concurrency.liftoffv2/LiftOffv2Task.java

package com.thinkjava.ch21.concurrency.liftoffv2;

/**
 * LiftOffv2 implements ITask
 * Contains testMethod(String msg, BlockingQueue<LiftOff>)
 * Override runTask() test for LinkedBlockingQueue ArrayBlockingQueue 
 * @author kevin.zhou <kevin.zhou@hotmail.co.uk>
 * @version 1.0
 * @date 2016-08-28
 */

import java.util.concurrent.*;
import java.io.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import static com.kevinking.util.sprinttool.KeSprint.*;
import com.thinkjava.ch21.concurrency.LiftOff;
import com.thinkjava.ch21.concurrency.ITask;

@Component("liftOffTaskv2")
public class LiftOffv2Task   implements ITask {
    protected void testMethod(String msg, BlockingQueue<LiftOff> queue) {
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread thread = new Thread(runner);
        thread.start();

        for (int i=0; i<=5; i++) {
            runner.add(new LiftOff());
        }

        // sprintlnYellow("Press 'Enter' (" + msg + ")");

        // try {
        //     new BufferedReader(
        //         new InputStreamReader(System.in)).readLine();
        // } catch(java.io.IOException e) {
        //     throw new RuntimeException(e);
        // }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            sprintlnRed("Thread INTERRUPTED!");
        }

        thread.interrupt();
        sprintlnGreen("Finished " + msg + " test");
    }

    @Override
    public void runTask() {
        testMethod("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
        testMethod("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
    }
}