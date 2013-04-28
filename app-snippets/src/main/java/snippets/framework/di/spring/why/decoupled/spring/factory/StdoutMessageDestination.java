package snippets.framework.di.spring.why.decoupled.spring.factory;

public class StdoutMessageDestination implements IMessageDestination {
    public void write(String message) {
        System.out.println(message);
    }
}
