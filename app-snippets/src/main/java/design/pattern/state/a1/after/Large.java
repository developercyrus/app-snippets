package design.pattern.state.a1.after;

public class Large implements State { 
    public void next(FireSwitch sw) { 
        sw.setState(new Off()); 
        System.out.println( "off fire" ); 
    }
}  
