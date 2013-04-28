package design.pattern.factory.a1.before;

public class ServiceZ implements Service {
    private final Logger logger = new ConsoleLogger(this.getClass());
    
    @Override
    public void doSomething(){
        logger.info("doSomething start");
        // code...
        logger.info("doSomething end");
    }
}