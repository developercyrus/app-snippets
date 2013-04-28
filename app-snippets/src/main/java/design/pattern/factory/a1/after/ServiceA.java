package design.pattern.factory.a1.after;

public class ServiceA implements Service {
    private final Logger logger = LoggerFactory.createLogger(this.getClass());
    
    @Override
    public void doSomething(){
        logger.info("doSomething start");
        // code...
        logger.info("doSomething end");
    }
}