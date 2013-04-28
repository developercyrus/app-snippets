package snippets.framework.di.spring.why.decoupled.interface1;

public class SimpleMessageSource implements IMessageSource {
    private final String message;
    
    public SimpleMessageSource(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
