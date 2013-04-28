package design.pattern.state.a1.after;

public class Off implements State { 
    public void next(FireSwitch sw) { 
        sw.setState(new Small()); 
        System.out.println( "small fire" ); 
    }
}