package snippets.jdk.lang.string.format.a1;

public class AtomFormatter {
    public static String getData(String template, Object ... args) {
        return String.format(template, args);
    }
}
