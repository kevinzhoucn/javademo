package demostate;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GumballMachineConfig.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class GumballMachineTest
{
	@Autowired
	private GumballMachine gumballMachine;

    @Test
    public void gumbalMachineTest() {
        // GumballMachine gumballMachine = new GumballMachine();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
