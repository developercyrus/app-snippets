package snippets.jdk.thread.threadlocal.a1;

public class BusinessService {
    public void businessMethod() {
        // get the context from threadlocal
        Context context = ContextContainer.get();
        System.out.println(context.getTransactionId());
    }
}
