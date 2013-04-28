package design.pattern.state.a1.after;

public class FireSwitch { 
    private State current;

    public FireSwitch() { 
        current = new Off();         
    }

    public void setState(State s) { 
        current = s; 
    }

    public void next() { 
        current.next(this); 
    }
} 