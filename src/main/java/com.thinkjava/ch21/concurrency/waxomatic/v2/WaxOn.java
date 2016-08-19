//: com.thinkjava.ch21.concurrency.waxomatic.v2/WaxOn.java

package com.thinkjava.ch21.concurrency.waxomatic.v2;

/**
 * WaxOn implements Runnable
 * Enable waxed / set waitForBuffing
 * @author kevin.zhou <kevin.zhou@hotmail.co.uk>
 * @version 1.0
 * @date 2016-08-27
 **/

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import static com.kevinking.util.sprinttool.KeSprint.*;

@Component("waxOnv2")
public class WaxOn implements Runnable {
    @Autowired
    @Qualifier("carv2")
    private Car car;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {                
                TimeUnit.MILLISECONDS.sleep(300);
                car.waxed();
                sprintlnGreen("WaxOn");
                car.waitForBuffing();
            }
        } catch(InterruptedException e) {
            sprintlnRed("WaxOn INTERRUPTED!");
        }        
    }
}