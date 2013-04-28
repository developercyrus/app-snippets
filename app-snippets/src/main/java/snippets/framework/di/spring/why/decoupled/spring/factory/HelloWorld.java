package snippets.framework.di.spring.why.decoupled.spring.factory;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;;

public class HelloWorld {
    public static void main(String[] args) {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(new ClassPathResource("snippets/framework/di/spring/why/decoupled/spring/factory/helloworld-context-spring.properties"));
        IMessageSource source = (IMessageSource)bf.getBean("source");
        IMessageDestination destination = (IMessageDestination)bf.getBean("destination");
        source.setMessage("Hello World");
        destination.write(source.getMessage());
    }  
}
