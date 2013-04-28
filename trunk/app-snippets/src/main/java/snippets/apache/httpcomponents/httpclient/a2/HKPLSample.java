package snippets.apache.httpcomponents.httpclient.a2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HKPLSample {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        DefaultHttpClient client = new DefaultHttpClient();  
        client =  WebClientDevWrapper.wrapClient(client);
        client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);

        accessMainPage(client);
        login(client);
        String htmlStr = getProfile(client);
        extract(htmlStr);
    }
    
    public static void accessMainPage(DefaultHttpClient client) throws ClientProtocolException, IOException {
        String url = "https://webcat.hkpl.gov.hk/";
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = client.execute(httpget);
        HttpEntity entity = response.getEntity();
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        System.out.println("login status code: " + statusCode);
        EntityUtils.consume(entity);
        

        CookieStore cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        if (cookies.isEmpty()) {
            System.out.println("Cookie None");
        } 
        else {
            for (Cookie cookie : cookies) {
                System.out.println("- " + cookie.toString());
            }
        }        
    }
    
    public static void login(DefaultHttpClient client) throws ClientProtocolException, IOException {
        String url = "https://webcat.hkpl.gov.hk/auth/login?wicket:bookmarkablePage=:com.vtls.chamo.webapp.component.OpacLoginPage&wicket:interface=:0:loginForm::IFormSubmitListener::";                    
        String username = "";
        String password = "";                
        String login = "登入讀者帳戶";

        List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();  
        data.add(new BasicNameValuePair("username", username));  
        data.add(new BasicNameValuePair("password", password));
        data.add(new BasicNameValuePair("login", login));  
        
        HttpPost httppost = new HttpPost(url);  
        httppost.setEntity(new UrlEncodedFormEntity(data, HTTP.UTF_8)); 
        HttpResponse response = client.execute(httppost);
        HttpEntity entity = response.getEntity();
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        System.out.println("login status code: " + statusCode);
        EntityUtils.consume(entity);
        
        CookieStore cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        if (cookies.isEmpty()) {
            System.out.println("Cookie None");
        } 
        else {
            for (Cookie cookie : cookies) {
                System.out.println("- " + cookie.toString());
            }
        }  
    }
    
    public static String getProfile(DefaultHttpClient client) throws ClientProtocolException, IOException {
        String url = "https://webcat.hkpl.gov.hk/?wicket:bookmarkablePage=:com.vtls.chamo.webapp.component.patron.PatronAccountPage&theme=WEB";
        HttpGet httpget = new HttpGet(url);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = client.execute(httpget, responseHandler);
        //System.out.println(responseBody);
        return responseBody;
    }
    
    public static void extract(String htmlStr) {
        Document doc2 = Jsoup.parse(htmlStr);
        Elements elements = doc2.select("#checkout");
        System.out.println(elements.html());
    }
}
