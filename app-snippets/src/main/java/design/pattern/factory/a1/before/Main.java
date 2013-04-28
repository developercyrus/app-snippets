package design.pattern.factory.a1.before;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        /*
         * If there're over 1,000 services required to change the logger 
         * from ConsoleLogger to FileLogger, I have to change it Service class by class.
         * So, in this case, Factory design pattern can resolve such problem.         * 
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
