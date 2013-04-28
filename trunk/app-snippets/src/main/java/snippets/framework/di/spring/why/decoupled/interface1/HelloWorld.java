package snippets.framework.di.spring.why.decoupled.interface1;

public class HelloWorld {
    public static void main(String[] args) {
        IMessageSource source = new SimpleMessageSource("Hello World");
        IMessageDestination destination = new StdoutMessageDestination();
        destination.write(source.getMessage());
    }
}
