package snippets.framework.di.spring.why.decoupled.spring.beam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"snippets/framework/di/spring/why/decoupled/spring/beam/spring-common.xml"});
        IMessageSource source = (IMessageSource)context.getBean("source");
        IMessageDestination destination = (IMessageDestination)context.getBean("destination");
        destination.write(source.getMessage());
    }
}
