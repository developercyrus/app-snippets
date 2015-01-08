package snippets.jdk.lang.string.codepointat;

public class InternalRepresentedInteger {
    public static void main(String[] args) {
        String word = "銵�";
        System.out.println(word.codePointAt(0)); //internally represented by integer.
    }
}
