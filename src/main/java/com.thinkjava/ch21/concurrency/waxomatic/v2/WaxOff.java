//: com.thinkjava.ch21.concurrency.waxomatic.v2/WaxOff.java

package com.thinkjava.ch21.concurrency.waxomatic.v2;

/**
 * Thread WaxOff set status to buffed
 * enable waitForWaxing
 **/

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import static com.kevinking.util.sprinttool.KeSprint.*;

@Component("waxOffv2")
public class WaxOff implements Runnable {
    @Autowired
    @Qualifier("carv2")
    private Car car;

    @Override
    public void run() {
        // sprintlnGreen("Running from WaxOff:");
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(200);
                car.waitForWaxing();
                sprintlnGreen("WaxOff");
                car.buffed();
            }
        } catch(InterruptedException e) {
            sprintlnRed("WaxOff INTERRUPTED!");
        }
    }
}///:~