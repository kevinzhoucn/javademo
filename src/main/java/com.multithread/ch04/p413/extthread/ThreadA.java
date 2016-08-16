//: com.multithread.ch04.p413.extthread/ThreadA.java

package com.multithread.ch04.p413.extthread;

/** Multi-thread in Java Example program.
 * Use Condition Wait Notify Eror - ThreadA.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.multithread.ch04.p413.service.*;

@Component
public class ThreadA implements Runnable {

	/** private field MyService
	 */
	private MyService myService;

	@Autowired
	public ThreadA(MyService myService) {
		this.myService = myService;
	}

	@Override
	public void run() {
		myService.await();
	}

	public void signal() {
		this.myService.signal();
	}
}
