package snippets.framework.htmlunit.a1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
public class PolyULibraryDemo {
    
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, GeneralSecurityException {
        String username = "";
        String password = "";
        
        String url = "https://library.polyu.edu.hk/patroninfo";
        WebClient webClient = new WebClient();
        webClient.setUseInsecureSSL(true);
        HtmlPage page = (HtmlPage) webClient.getPage(url);
    
        HtmlForm patform = page.getFormByName("patform");
        HtmlPasswordInput code = (HtmlPasswordInput) patform.getInputByName("code");
        HtmlPasswordInput pin = (HtmlPasswordInput) patform.getInputByName("pin");
        code.setValueAttribute(username);
        pin.setValueAttribute(password);
        
        HtmlButton submitButton = (HtmlButton)page.createElement("button");
        submitButton.setAttribute("type", "submit");
        patform.appendChild(submitButton);
        
        HtmlPage result = submitButton.click();
        System.out.println(result.asText());

    }
}
