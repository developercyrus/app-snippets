package snippets.library.joda.money.a1;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

public class MoneySingletonTest {
    @Test
    public void test() {
        Money moneyUSD = MoneySingleton.getInstance("USD 23.87");        
        BigDecimal conversionRate = new BigDecimal(5.1);
        Money moneyEUR = moneyUSD.convertedTo(CurrencyUnit.EUR, conversionRate, RoundingMode.UP);
        assertEquals(121, moneyEUR.getAmountMajorInt());
    }
}