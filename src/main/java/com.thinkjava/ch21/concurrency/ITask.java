//: com.thinkjava.ch21.concurrency/ITask.java

package com.thinkjava.ch21.concurrency;

/** Demonstration of the Interface ITask
 *  @author kevin.zhou
 *  @version 1.0
 */

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

public interface ITask{
	// Method to run the main thread
	public void runTask();
} ///:~