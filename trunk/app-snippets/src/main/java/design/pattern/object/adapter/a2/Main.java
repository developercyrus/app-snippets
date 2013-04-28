package design.pattern.object.adapter.a2;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
         * Target - Iterable of Character
         * Adapter - Iterable
         * Adaptee - String         
         */
        String original = new String("I like foreach!");
        
        for(Character c: new IterableString(original)) {
            System.out.println(c);
        }
    }
}