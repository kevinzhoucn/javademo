//: com.multithread.ch04.p413.service/MyService.java

package com.multithread.ch04.p413.service;

/** Multi-thread in Java Example program.
 * Use Condition Wait Notify Eror.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import org.springframework.stereotype.Component;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class MyService {

	/** 使用ReentrantLock来加锁实现同步
	 * 
	 */
	private Lock lock = new ReentrantLock();

	/**  使用condition类来实现等待/通知模式
	 */
	private Condition condition = lock.newCondition();

	/** await method to wait thread singal to run next 
	 *  the thread will suspend and waiting for singal
	 */
	public void await() {
		try {
			lock.lock();
			System.out.println(" await time is: " + System.currentTimeMillis());
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	/* Output: (55% match)
	*///:~

	public void signal() {
		try {
			lock.lock();
			System.out.println("signal 时间为 " + System.currentTimeMillis());
			condition.signal();			
		} finally {
			lock.unlock();
		}
	}
}