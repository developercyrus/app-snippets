package snippets.jee.jaxws.a1;

import java.util.Date;
import javax.jws.WebService;

@WebService(endpointInterface = "snippets.jee.jaxws.a1.TimeServer")
public class TimeServerImpl implements TimeServer {
    private String name;
    
    public String getTimeAsString() {
        return new Date().toString();
    }
    
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name + " is processed.";
    }
}