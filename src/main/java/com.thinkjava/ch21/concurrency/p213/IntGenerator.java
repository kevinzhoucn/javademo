//: com.thinkjava.ch21.concurrency.p213/IntGenerator.java

package com.thinkjava.ch21.concurrency.p213;
/**
 * Abstract class IntGenerator
 * Include abstract method next()
 * @author kevin.zhou
 */

public abstract class IntGenerator {
	/*
	 * Field canceled type is boolean, it's atomic
	 * Set to volatile to make visiable
	 */
	private volatile boolean canceled = false;

	/*
	 * Abstract method next() child to implement
	 */
	public abstract int next();

	/* 
	 * Call cancel to set canceled to true
	 */
	public void cancel() {
		canceled = true;
	}

	/* 
	 * Reture value of canceled
	 */
	public boolean isCanceled() {
		return canceled;
	}
}///:~