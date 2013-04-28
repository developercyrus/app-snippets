package snippets.framework.di.spring.why.decoupled.factory;

public class StdoutMessageDestination implements IMessageDestination {
    public void write(String message) {
        System.out.println(message);
    }
}
