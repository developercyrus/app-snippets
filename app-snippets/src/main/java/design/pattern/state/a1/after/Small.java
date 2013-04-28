package design.pattern.state.a1.after;

public class Small implements State { 
    public void next(FireSwitch sw) { 
        sw.setState(new Medium()); 
        System.out.println( "medium fire" ); 
    }
} 