package snippets.jdk.thread.a1;

public class Main {
    public static void main (String[] args) {
        Runnable r = new Runner("Thread A");
        Thread t = new Threader("Thread B");
        r.run();
        t.start();
    }
}
