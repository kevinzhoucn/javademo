package demostate;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;

/**
 * Unit test for simple App.
 */
public class GumballMachineTest
{
    @Test
    public void gumbalMachineTest() {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
