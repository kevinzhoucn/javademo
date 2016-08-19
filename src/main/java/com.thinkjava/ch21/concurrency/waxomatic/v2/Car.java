//: com.thinkjava.ch21.concurrency.waxomatic.v2/Car.java

package com.thinkjava.ch21.concurrency.waxomatic.v2;

/**
 * WaxOMaticV2 will use ReentrantLock and Condition
 * Car includes ReentrantLock, Condition
 * Includes methods buffed, waxed, waitForBuffing, waitForWaxing
 * Use lock.lock(), lock.unlock(), condition.wait()
 * @author kevin.zhou
 * @author <kevin.zhou@hotmail.co.uk>
 * @version 1.0
 * @date 2016-08-27
 **/

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import static com.kevinking.util.sprinttool.KeSprint.*;
import org.springframework.stereotype.Component;

@Component("carv2")
public class Car {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;

    public void waxed() {
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
            // sprintlnGreen("Car finish wax!");
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
            // sprintlnGreen("Car finish buff!");
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while(waxOn == true) {                
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while(waxOn == false) {                
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}