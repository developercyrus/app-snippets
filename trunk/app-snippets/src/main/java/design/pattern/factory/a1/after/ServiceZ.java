package design.pattern.factory.a1.after;

public class ServiceZ implements Service {
    private final Logger logger = LoggerFactory.createLogger(this.getClass());
    
    @Override
    public void doSomething(){
        logger.info("doSomething start");
        // code...
        logger.info("doSomething end");
    }
}