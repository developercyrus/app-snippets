package snippets.http.server.mortbay.jetty.a1;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.util.ByteArrayISO8859Writer;

public class GetContentOkHandler extends AbstractHandler { 
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
        OutputStream out = response.getOutputStream(); 
        ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer(); 
        writer.write("It works"); 
        writer.flush(); 
        response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size()); 
        writer.writeTo(out); 
        out.flush(); 
    }
}