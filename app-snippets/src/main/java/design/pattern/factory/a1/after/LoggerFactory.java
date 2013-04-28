package design.pattern.factory.a1.after;

public class LoggerFactory {
    public static Logger createLogger(Class<?> clazz){
        return new FileLogger(clazz);
    }
}