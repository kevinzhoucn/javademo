//: com.thinkjava.ch21.concurrency/TaskWithResultTask.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Runnable interface
 *  @author kevin.zhou
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import java.util.concurrent.*;
import java.util.*;

@Component("TaskWithResultTask")
public class TaskWithResultTask implements ITask {

	// Method to run the thread
	@Override
	public void runTask() {
		System.out.println("TaskWithResultTask test: Start");

		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results =
			new ArrayList<Future<String>>();

		for(int i=0; i<10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}

        for(Future<String> fs : results) {
        	try {
        		// get() blocks until completion:
        		System.out.println(fs.get());
        	} catch(InterruptedException e) {
        		System.out.println(e);
        		return;
        	} catch(ExecutionException e) {
        		System.out.println(e);        		
        	} finally {
        		exec.shutdown();
        	}
        }

        System.out.println("TaskWithResultTask test: End");
	}
} ///:~