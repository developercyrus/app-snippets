package snippets.jee.jaxws.a1;

import javax.xml.ws.Endpoint;

public class TimeServerPublisher {
    public static void main(String[] args) {
        String address = "http://localhost:9876/ts";
        TimeServer implementor = new TimeServerImpl();
        Endpoint.publish(address, implementor);
    }
}

