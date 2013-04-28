package snippets.apache.httpcomponents.httpclient.a1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class Sample {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        String url = "https://accounts.google.com/o/oauth2/token";
        String client_id = "";
        String client_secret = "";
        String refresh_token = "";
        String grant_type = "refresh_token";
        
        List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();  
        data.add(new BasicNameValuePair("client_id", client_id));  
        data.add(new BasicNameValuePair("client_secret", client_secret));  
        data.add(new BasicNameValuePair("refresh_token", refresh_token));
        data.add(new BasicNameValuePair("grant_type", grant_type));
        
        HttpClient client = new DefaultHttpClient();  
        HttpPost httppost = new HttpPost(url);  
        httppost.setEntity(new UrlEncodedFormEntity(data, HTTP.UTF_8)); 
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String respondBody = client.execute(httppost, responseHandler);
        System.out.println(respondBody);           
    }
}
