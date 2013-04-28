package snippets.jdk.util.collection.iterable.a1;

public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer("I am Peter Chan");
        
        for (String token: tokenizer) {
            System.out.println(token);
        }
    }
}