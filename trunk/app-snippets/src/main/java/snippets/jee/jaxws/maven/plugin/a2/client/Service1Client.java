package snippets.jee.jaxws.maven.plugin.a2.client;

import snippets.jee.jaxws.maven.plugin.a2.stub.Service1;
import snippets.jee.jaxws.maven.plugin.a2.stub.Service1Soap;


public class Service1Client {
    public static void main(String[] args) {
        Service1 s1 = new Service1();
        Service1Soap s = s1.getService1Soap();
        System.out.println(s.sayHello());
    }
}

