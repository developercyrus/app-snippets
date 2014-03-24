package snippets.bytecode.btrace.trace.a1;

import java.util.Random;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        while (true) {
            Random random = new Random();
            execute(random.nextInt(4000));
        }
    }

    public static void execute(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("sleep time is=>" + sleepTime);
    }
}
