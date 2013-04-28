package snippets.library.joda.time.a1;

import org.joda.time.DateTime;

public class DateTimeSingleton {
    private static DateTime instance = null;

    private DateTimeSingleton() {
    }

    public static DateTime getInstance(String s) {
        if (instance == null) {
            instance = new DateTime(s);
        }
        return instance;
    }
}
