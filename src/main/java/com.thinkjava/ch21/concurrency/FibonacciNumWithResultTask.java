//: com.thinkjava.ch21.concurrency/FibonacciNumWithResultTask.java

package com.thinkjava.ch21.concurrency;

/** Computer fibonacciNum with thread
 *  Implements the callable
 *  @author Kevin
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import java.util.concurrent.*;
import java.util.*;

@Component("FibonacciNumWithResultTask")
public class FibonacciNumWithResultTask implements ITask {
	
	// Method to run the thread
	@Override
	public void runTask() {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();

		results.add(exec.submit(new FibonacciNumWithResult()));

		for (Future<String> fs : results) {
			try {
				System.out.println(fs.get());
			} catch(InterruptedException e) {
				System.out.println(e);
			} catch(ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
		}		
	}
}