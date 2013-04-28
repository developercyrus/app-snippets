package design.pattern.proxystatic.a1.before;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Bird { 
    private Logger logger = Logger.getLogger(this.getClass().getName()); 

    public void hello(String name) { 
        logger.log(Level.INFO, "hello method starts....");
        System.out.println("Hello, " + name); 
        logger.log(Level.INFO, "hello method ends...."); 
    } 
} 