package snippets.jee.jaxws.maven.plugin.a1;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import snippets.jee.jaxws.maven.plugin.a1.client.CurrencyWebServiceClient;

public class CurrencyWebServiceClientTest {

	@Ignore
    @Test
    public void testUSD2HK() {
        System.out.println(CurrencyWebServiceClient.USD2HK());
        assertTrue(CurrencyWebServiceClient.USD2HK() >  0.0D);
    }
}
