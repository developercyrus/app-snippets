package snippets.jee.jaxws.maven.plugin.a1.client;

import snippets.jee.jaxws.maven.plugin.a1.stub.Currency;
import snippets.jee.jaxws.maven.plugin.a1.stub.CurrencyConvertor;

public class CurrencyWebServiceClient {
    public static double USD2HK() {
        CurrencyConvertor currencyConvertor = new CurrencyConvertor();
        return currencyConvertor.getCurrencyConvertorSoap().conversionRate(Currency.USD, Currency.HKD);	
    }
    
    public static void main(String[] args) {
    	System.out.println(USD2HK());
    }
}

