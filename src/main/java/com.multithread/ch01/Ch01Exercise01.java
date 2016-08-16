//: com.multithread.ch01/Ch01Exercise01.java

package com.multithread.ch01;

/** Multi-thread in Java Example program.
 * Implements interface runnable.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import org.springframework.stereotype.Component;

@Component
public class Ch01Exercise01 implements Runnable {
	/** Fields with int
	 * public field int number01 without initialize
	 */
	public int field01;

	/** Method sayHi
	 */
	public void sayHi() {
		System.out.println("Hi");
	} 
	/* Output: (55% match)
	Hi
	*///:~

	@Override
	public void run() {
		this.sayHi();
	}
}