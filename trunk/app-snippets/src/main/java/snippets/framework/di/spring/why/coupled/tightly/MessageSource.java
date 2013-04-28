package snippets.framework.di.spring.why.coupled.tightly;

public class MessageSource {
    private final String message;
    
    public MessageSource(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
