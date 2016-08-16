//: com.thinkjava.ch21.concurrency/ConcurrencyTask.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Runnable ConcurrencyTask
 *  @author kevin.zhou
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConcurrencyTask implements Runnable {

	@Autowired
	private LiftOff liftOff;

	// Method to run the main thread
	public void run() {
		System.out.println("Lift off concurrecny test: Start");
        Thread thread = new Thread(liftOff);
        thread.start();
        System.out.println("Lift off concurrecny test: End");
	}
} ///:~