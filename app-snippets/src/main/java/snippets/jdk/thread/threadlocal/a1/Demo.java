package snippets.jdk.thread.threadlocal.a1;

public class Demo extends Thread {
    /*
     * http://veerasundar.com/blog/2010/11/java-thread-local-how-to-use-and-code-sample/
     */
    
    public static void main(String args[]) {
        Thread threadOne = new Demo();
        threadOne.start();

        Thread threadTwo = new Demo();
        threadTwo.start();
    }

    @Override
    public void run() {
        // sample code to simulate transaction id
        Context context = new Context();
        context.setTransactionId(getName());

        // set the context object in thread local to access it somewhere else
        ContextContainer.set(context);

        /* note that we are not explicitly passing the transaction id */
        new BusinessService().businessMethod();
        ContextContainer.unset();

    }
}