//: com.thinkjava.ch04/FibonacciNumTest.java

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

import com.thinkjava.config.Ch04Config;

/**
 * Unit test for MathComputeTest App.
 * Remove FibonacciNumTest and VampireNumTest 08/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Ch04Config.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class MathComputeTest
{
	@Autowired
	private IComputeNum fibonacciNum;

	@Autowired
	private IComputeNum vampireNum;

    @Test
    public void mathComputerTest() {
    	System.out.println("Comput fibonacci number:");
        fibonacciNum.compute();

        System.out.println("Comput vampire number:");
        vampireNum.compute();
    }
}
