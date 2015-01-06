package snippets.jdk.thread.a1;

public class Runner implements Runnable {
    private final String name;
    
    public Runner(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(name + " is running.");
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
