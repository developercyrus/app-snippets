package snippets.jee.jaxws.a1;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface TimeServer {
    @WebMethod
    String getTimeAsString();
    
    @WebMethod
    long getTimeAsElapsed();
    
    @WebMethod
    void setName(String name);
    
    @WebMethod
    String getName();
}
