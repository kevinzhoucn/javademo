package demostate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class HasQuarterState implements IState
{
    GumballMachine gumballMachine;

    public HasQuarterState( GumballMachine gumballMachine ) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can't insert another quarter");        
    }

    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank() {
        System.out.println("You turned");
        System.out.println("From has quarter state!");
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
