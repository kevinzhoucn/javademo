//: com.thinkjava.ch21.concurrency.p213/EvenChecker.java

package com.thinkjava.ch21.concurrency.p213;
/**
 * class EvenChecker
 * Composite IntGenerator instance
 * @author kevin.zhou
 */
import java.util.concurrent.*;

public class EvenChecker implements Runnable {
	/*
	 * Composite instance IntGenerator
	 */
	private IntGenerator generator;

	/*
	 * Field final id mark the thread
	 */
	private final int id;

	/*
	 * Construct for EvenChecker
	 * @param IntGenerator g
	 * @param int ident
	 */
	public EvenChecker(IntGenerator g, int ident) {
		this.generator = g;
		this.id = ident;
	}

	/* 
	 * Implement run()
	 */
	public void run() {
		while(!generator.isCanceled()) {
			int val = generator.next();
			if(val % 2 != 0) {
				System.out.println(val + " not even!");
				generator.cancel(); // Cancels all EvenCheckers
			} else {
				// System.out.println(val + " value!");
			}
		}
	}

}///:~