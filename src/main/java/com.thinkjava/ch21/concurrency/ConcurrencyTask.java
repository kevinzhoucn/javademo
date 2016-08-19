//: com.thinkjava.ch21.concurrency/ConcurrencyTask.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Runnable ConcurrencyTask
 *  @author kevin.zhou
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
public class ConcurrencyTask implements Runnable {
	@Autowired
	// @Qualifier("CachedThreadPool")
	// @Qualifier("TaskWithResultTask")
	// @Qualifier("FibonacciNumWithResultTask")
    // @Qualifier("EvenCheckerTask")
    // @Qualifier("entranceTask")
    // @Qualifier("interruptingTask")
    // @Qualifier("waxOMatic")
    // @Qualifier("exerciseTask")
    // @Qualifier("exerciseTask02")
    // @Qualifier("restaurantTask")
    // @Qualifier("waxOMaticv2")
    @Qualifier("liftOffTaskv2")
	private ITask taskItem;

	// Method to run the main thread
	public void run() {
		taskItem.runTask();
	}
} ///:~