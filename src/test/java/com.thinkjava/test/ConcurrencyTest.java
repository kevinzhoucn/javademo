//: com.thinkjava.ch04/ConcurrencyTest.java

package com.thinkjava.ch04;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.thinkjava.config.ConcurrencyConfig;

/**
 * Unit test for MathComputeTest App.
 * Remove FibonacciNumTest and VampireNumTest 08/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcurrencyConfig.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class ConcurrencyTest
{
	@Autowired
	private Runnable concurrencyTask;

    @Test
    public void liftOffTest() {
    	concurrencyTask.run();
    }
}