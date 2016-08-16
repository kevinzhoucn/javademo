//: com.thinkjava.ch21.concurrency/FibonacciNumWithResult.java

package com.thinkjava.ch21.concurrency;

/** Computer fibonacciNum with thread
 *  Implements the callable
 *  @author Kevin
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import java.util.concurrent.*;
import com.thinkjava.ch04.FibonacciNum;

@Component
public class FibonacciNumWithResult extends FibonacciNum implements Callable {
	
	public FibonacciNumWithResult() {
		super();
	}

	public String call() {
		return "result of FibonacciNum: 1,1,2,3,5,8,13,21,34";
	}
}