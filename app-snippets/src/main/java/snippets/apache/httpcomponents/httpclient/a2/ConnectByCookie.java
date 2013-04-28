package snippets.apache.httpcomponents.httpclient.a2;

import java.io.IOException;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class ConnectByCookie {
    public static void main(String[] args) throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();  
        client =  WebClientDevWrapper.wrapClient(client);
        String url = "https://webcat.hkpl.gov.hk/?wicket:bookmarkablePage=:com.vtls.chamo.webapp.component.patron.PatronAccountPage&theme=WEB";
        HttpGet httpget = new HttpGet(url);
        
        //this is got from browser
        httpget.addHeader("Cookie", "BIGipServerwebcat.hkpl.gov.hk-pool=; JSESSIONID=");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = client.execute(httpget, responseHandler);
        System.out.println(responseBody);
    }
}
