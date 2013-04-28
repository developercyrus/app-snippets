package snippets.framework.di.spring.why.decoupled.interface1;

public class StdoutMessageDestination implements IMessageDestination {
    public void write(String message) {
        System.out.println(message);
    }
}
