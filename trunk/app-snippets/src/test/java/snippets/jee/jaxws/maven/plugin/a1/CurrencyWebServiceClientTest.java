package snippets.jee.jaxws.maven.plugin.a1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import snippets.jee.jaxws.maven.plugin.a1.client.CurrencyWebServiceClient;

public class CurrencyWebServiceClientTest {

    /*
        sometimes it can't connect to http://www.webservicex.net/CurrencyConvertor.asmx?WSDL
     */
    
	//@Ignore
    @Test
    public void testUSD2HK() {
        System.out.println(CurrencyWebServiceClient.USD2HK());
        assertTrue(CurrencyWebServiceClient.USD2HK() >  0.0D);
    }
}
