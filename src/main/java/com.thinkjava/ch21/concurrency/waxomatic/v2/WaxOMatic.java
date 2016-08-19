//: com.thinkjava.ch21.concurrency.waxomatic.v2/WaxOMatic.java

package com.thinkjava.ch21.concurrency.waxomatic.v2;

/**
 * WaxOMatic task to run waxoff waxon
 * @author kevin.zhou <kevin.zhou@hotmail.co.uk>
 * @version 1.0
 * @date 2016-08-27
 **/

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.thinkjava.ch21.concurrency.ITask;
import static com.kevinking.util.sprinttool.KeSprint.*;

@Component("waxOMaticv2")
public class WaxOMatic implements ITask {
    @Autowired
    @Qualifier("waxOnv2")
    private Runnable waxOn;

    @Autowired
    @Qualifier("waxOffv2")
    private Runnable waxOff;

    @Override
    public void runTask() {
        sprintlnGreen("WaxOMatic Start!");
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(waxOn);
        exec.execute(waxOff);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch(InterruptedException e) {
            sprintlnRed("WaxOMatic INTERRUPTED!");
        }

        exec.shutdownNow();
        sprintlnGreen("WaxOMatic End!");
    }
}