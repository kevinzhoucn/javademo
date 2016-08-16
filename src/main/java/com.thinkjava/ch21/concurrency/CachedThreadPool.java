//: com.thinkjava.ch21.concurrency/CachedThreadPool.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Runnable interface
 *  @author kevin.zhou
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import java.util.concurrent.*;

@Component("CachedThreadPool")
public class CachedThreadPool implements ITask {

	// Method to run the thread
	@Override
	public void runTask() {
		System.out.println("Cached Thread Pool concurrecny test: Start");

		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i=0; i<5; i++) {
			exec.execute(new LiftOff());
		}

		exec.shutdown();
        System.out.println("Cached Thread Pool concurrecny test: End");
	}
} ///:~