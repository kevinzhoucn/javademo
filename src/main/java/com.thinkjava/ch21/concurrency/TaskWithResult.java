//: com.thinkjava.ch21.concurrency/TaskWithResult.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Runnable TaskWithResult
 *  @author kevin.zhou
 *  @version 1.0
 */

import java.util.concurrent.*;

public class TaskWithResult implements Callable<String> {

	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() {
		return "result of TaskWithResult " + id;
	}
} ///:~