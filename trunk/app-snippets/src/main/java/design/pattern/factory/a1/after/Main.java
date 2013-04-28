package design.pattern.factory.a1.after;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * http://pro.ctlok.com/blog/2012/04/02/design-pattern-factory.html
         */        
        
        
        /*
         * If I want to change the Logger from ConsoleLogger to FileLogger, I'm just 
         * required to change LoggerFactory once only, regardless how many Service there are.
         */
        
        List<Service> services = new ArrayList<Service>();
        services.add(new ServiceA());        
        services.add(new ServiceB());
        services.add(new ServiceZ());
        
        for (Service service : services) {
            service.doSomething();
        }        
    }
}
