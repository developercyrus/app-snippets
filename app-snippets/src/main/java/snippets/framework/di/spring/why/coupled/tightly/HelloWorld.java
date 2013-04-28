package snippets.framework.di.spring.why.coupled.tightly;

public class HelloWorld {
    public static void main(String[] args) {
        MessageSource source = new MessageSource("Hello World");
        MessageDestination destination = new MessageDestination();
        destination.write(System.out, source.getMessage());
    }
}
