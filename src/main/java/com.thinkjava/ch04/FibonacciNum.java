//: com.thinkjava.ch04/FibonacciNum.java

package com.thinkjava.ch04;

/** Thinking in Java Example program.
 * Displays FibonacciNum Number.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import java.util.Arrays;
import org.springframework.stereotype.Component;
import java.util.stream.*;

@Component
public class FibonacciNum implements IComputeNum {

	/** Java8 Stream method to computer Fibonacci number
	 */

	/**
	 * Fibonacci Stream method
	 * @Title: fnStreamMethod
	 * @Description: TODO
	 * @param @param n
	 * @param @return    
	 * @return 
	 * @throws
	*/
	public void fnStreamMethod(int n) {
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
			  .limit(n)
			  .map(t -> t[0])
			  .forEach(System.out::println);
	}/* Output: (55% match)
	  	1,1,2,3,5,8,11,19,30
	*///:~

	/** Implements interface method
	 */
	public void compute() {
		this.fnStreamMethod(10);
	}
}