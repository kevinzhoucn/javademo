package demostate;

public class GumballMachine {
    IState noQuarterState;
    IState hasQuarterState;

    IState state;
    int count;   

    public GumballMachine(int numberGumballs) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);

        this.count = numberGumballs;
        if ( numberGumballs > 0 ) {
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