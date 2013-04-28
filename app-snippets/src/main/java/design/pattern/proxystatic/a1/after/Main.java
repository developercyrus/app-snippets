package design.pattern.proxystatic.a1.after;

public class Main {
    public static void main(String[] args) {
        /*
         * While remaining the original Bird implementation, 
         * and keeping it clean without adding extra logging statement,
         * we can still achieve the logging through proxy 
         */
        Animal birdProxy = new BirdProxy(new Bird()); 
        birdProxy.hello("Mary");
    }
}
