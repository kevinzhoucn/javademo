//: com.thinkjava.ch21.concurrency.p213/EvenCheckerTask.java

package com.thinkjava.ch21.concurrency.p213;

/**
 * class EvenCheckerTask
 * Composite IntGenerator instance
 * @author kevin.zhou
 */
import java.util.concurrent.*;
import com.thinkjava.ch21.concurrency.ITask;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component("EvenCheckerTask")
public class EvenCheckerTask implements ITask {

	/*
	 * Autowired generator 
	 */
	@Autowired	
	@Qualifier("EvenGenerator")
	private IntGenerator generator;

	/*
	 * Override method to run task
	 */
	@Override
	public void runTask() {
		System.out.println("Even Checker concurrecny test: Start");

		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i=0; i<10 ; i++) {
			exec.execute(new EvenChecker(generator, i));
		}
		exec.shutdown();

		// try {
		// 	Thread.sleep(3000);
		// } catch(InterruptedException e){ 
		// 	e.printStackTrace();
		// }
        System.out.println("Even Checker concurrecny test: End");
	}

}///:~