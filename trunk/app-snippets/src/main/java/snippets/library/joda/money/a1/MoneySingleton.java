package snippets.library.joda.money.a1;

import org.joda.money.Money;

public class MoneySingleton {
    private static Money instance = null;

    private MoneySingleton() {
    }

    public static Money getInstance(String s) {
        if (instance == null) {
            instance = Money.parse(s);
        }
        return instance;
    }
}
