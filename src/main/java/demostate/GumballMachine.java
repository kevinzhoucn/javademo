package demostate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GumballMachine {
    IState noQuarterState;
    IState hasQuarterState;

    IState state;
    int count;
    GumballMachineConfig gumballMachineConfig;

    @Autowired
    public GumballMachine(GumballMachineConfig gumballMachineConfig) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);

        this.gumballMachineConfig = gumballMachineConfig;

        this.count = gumballMachineConfig.gumballNumber;
        if ( gumballMachineConfig.gumballNumber > 0 ) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(IState state) {
        this.state = state;
    }

    public IState getHasQuarterState() {
        return hasQuarterState;
    }

    public IState getNoQuarterState() {
        return noQuarterState;
    }

    public String toString() {
        // return "number of gumballs " + this.count.toString();
        return "Number of gumballs: " + String.valueOf(this.count);
        // return this.count.toString();
    }
} 