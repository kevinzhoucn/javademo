//: com.thinkjava.ch04/MultiThreadExerciseTest.java

package com.multithread.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.multithread.config.MultithreadConfig;
import com.multithread.ch04.p413.service.*;
import com.multithread.ch04.p413.extthread.*;
/**
 * Unit test for MultiThreadExerciseTest App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MultithreadConfig.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class MultiThreadExerciseTest
{
	@Autowired
	private Runnable ch01Exercise01;

	@Autowired
	private ThreadA threadA;

	@Ignore
    @Test
    public void exerciseRunableTest() {
    	System.out.println("Exercise Runnable: Begin");
        Thread thread = new Thread(ch01Exercise01);
        thread.start();
        System.out.println("Exercise Runnable: End");
    }

    @Test
    public void ch04p413ThreadATest() {
    	System.out.println("ThreadA Runnable: Begin");
    	Thread thread = new Thread(threadA);
    	thread.start();
    	try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	
    	threadA.signal();
    	System.out.println("ThreadA Runnable: End");
    }
}
