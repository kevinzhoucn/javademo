//: com.thinkjava.ch21.concurrency/LiftOffTask.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Runnable interface
 *  @author kevin.zhou
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("LiftOffTask")
public class LiftOffTask implements ITask {

	// Private field of LiftOff
	@Autowired
	private LiftOff liftOff;

	// Method to run the thread
	@Override
	public void runTask() {
		System.out.println("Lift off concurrecny test: Start");
        Thread thread = new Thread(liftOff);
        thread.start();
        System.out.println("Lift off concurrecny test: End");
	}
} ///:~