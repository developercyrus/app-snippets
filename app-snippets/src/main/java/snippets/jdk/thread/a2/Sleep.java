package snippets.jdk.thread.a2;

public class Sleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1");
        Thread.sleep(2000);
        System.out.println("2");
    }
}

