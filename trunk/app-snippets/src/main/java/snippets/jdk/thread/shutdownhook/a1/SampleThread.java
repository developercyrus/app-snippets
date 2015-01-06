package snippets.jdk.thread.shutdownhook.a1;

public class SampleThread {
    private Thread thread = null;

    public SampleThread() {
        thread = new Thread("Sample thread") {
            @Override
            public void run() {
                while (true) {
                    System.out.println("[Sample thread] Sample thread speaking...");
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException ie) {
                        System.out.println("[Sample thread] Stopping by calling break");
                        break;
                    }
                }
                System.out.println("[Sample thread] Stopped");
            }
        };
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }
}
