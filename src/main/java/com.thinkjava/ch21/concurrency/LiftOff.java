//: com.thinkjava.ch21.concurrency/LiftOff.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Runnable interface
 *  @author kevin.zhou
 *  @version 1.0
 */

import org.springframework.stereotype.Component;

@Component
public class LiftOff implements Runnable {

	// Default field of countDown number
	protected int countDown = 10;

	/* Field taskCount to count the number of thread
	 */
	private static int taskCount = 0;

	/* Field id to log current task number
	 */
	private final int id = taskCount++;
	
	public LiftOff() {}

	// Method to get lift status
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "). ";
	}

	// Method to run the thread
	public void run() {
		while(countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}
} ///:~