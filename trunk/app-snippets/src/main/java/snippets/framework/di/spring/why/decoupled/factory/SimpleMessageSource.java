package snippets.framework.di.spring.why.decoupled.factory;

public class SimpleMessageSource implements IMessageSource {
    private String message;
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
