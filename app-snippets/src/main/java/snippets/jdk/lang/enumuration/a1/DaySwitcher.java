package snippets.jdk.lang.enumuration.a1;

public class DaySwitcher {
    public static String turn(Day day) {
        switch (day) {
            case MONDAY: return "Mondays are bad.";
            case FRIDAY: return "Fridays are better.";
            default:     return "Midweek days are so-so.";
        }
    }
}
