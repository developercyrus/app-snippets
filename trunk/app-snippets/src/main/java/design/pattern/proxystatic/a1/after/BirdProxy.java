package design.pattern.proxystatic.a1.after;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BirdProxy implements Animal { 
    private Logger logger = Logger.getLogger(this.getClass().getName()); 
    private Animal animal; 

    public BirdProxy(Animal animal) { 
        this.animal = animal; 
    } 

    @Override
    public void hello(String name) { 
        logger.log(Level.INFO, "hello method starts...."); 
        animal.hello(name); 
        logger.log(Level.INFO, "hello method ends...."); 
    } 
}