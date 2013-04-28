package snippets.framework.htmlunit.a1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class HKPLDemo {
    /*
     *  still doesn't work, encountered javascript error 
     */
    
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, GeneralSecurityException {
        String url = "https://webcat.hkpl.gov.hk/auth/login";
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_6);
        webClient.setUseInsecureSSL(true);
        webClient.setThrowExceptionOnScriptError(false);
        HtmlPage page = (HtmlPage) webClient.getPage(url);
    
        HtmlForm form = (HtmlForm)page.getElementById("loginForm");
       
        HtmlPasswordInput username = (HtmlPasswordInput) form.getInputByName("username");
        HtmlPasswordInput password = (HtmlPasswordInput) form.getInputByName("password");
        HtmlSubmitInput login = (HtmlSubmitInput) form.getInputByName("login");
        username.setValueAttribute("");
        password.setValueAttribute("");
        
        //HtmlPage page2 = (HtmlPage) login.click();
        System.out.println(login.getValueAttribute());
        //System.out.println(page2);
        
    }
}
