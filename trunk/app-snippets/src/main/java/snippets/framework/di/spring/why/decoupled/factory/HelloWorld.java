package snippets.framework.di.spring.why.decoupled.factory;

public class HelloWorld {
    public static void main(String[] args) {
        BeanFactory bf = new BeanFactory("helloworld-context-factory.properties");
        IMessageSource source = (IMessageSource)bf.getBean("source");
        IMessageDestination destination = (IMessageDestination)bf.getBean("destination");
        source.setMessage("Hello World");
        destination.write(source.getMessage());
    }
}
