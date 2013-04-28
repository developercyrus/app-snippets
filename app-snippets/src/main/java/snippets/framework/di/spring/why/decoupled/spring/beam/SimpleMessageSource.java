package snippets.framework.di.spring.why.decoupled.spring.beam;

public class SimpleMessageSource implements IMessageSource {
    private String message;
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
