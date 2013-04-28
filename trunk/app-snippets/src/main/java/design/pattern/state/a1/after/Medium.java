package design.pattern.state.a1.after;

public class Medium implements State { 
    public void next(FireSwitch sw) { 
        sw.setState(new Large()); 
        System.out.println( "large fire" ); 
    } 
}  