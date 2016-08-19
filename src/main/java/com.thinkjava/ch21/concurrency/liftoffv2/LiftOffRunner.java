//: com.thinkjava.ch21.concurrency.liftoffv2/LiftOffRunner.java

package com.thinkjava.ch21.concurrency.liftoffv2;

/**
 * LiftOffRunner contains BlockingQueue rockets
 * Method add(LiftOff liftOff) to add Object LiftOff
 * Override run() take object from BlockingQueue rockets
 * If rockets is empty blcok and wait for item
 * @author kevin.zhou <kevin.zhou@hotmail.co.uk>
 * @version 1.0
 * @date 2016-08-28
 */

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.thinkjava.ch21.concurrency.LiftOff;
import static com.kevinking.util.sprinttool.KeSprint.*;

public class LiftOffRunner implements Runnable {
    /**
     * BlockingQueue LinkedBlockingQueue ArrayBlockingQueue DelayQueue PriorityBlockingQueue
     */
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue queue) {
        rockets = queue;
    }

    /**
     * add() to add LiftOff instance to rockets
     */
    public void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            sprintlnRed("LiftOffRunner add() INTERRUPTED!");
        }
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch(InterruptedException e) {
            sprintlnRed("LiftOffRunner run() INTERRUPTED!");
        }
        sprintlnGreen("Exiting LiftOffRunner!");
    }
}