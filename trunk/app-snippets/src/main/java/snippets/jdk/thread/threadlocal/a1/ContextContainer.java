package snippets.jdk.thread.threadlocal.a1;

public class ContextContainer {
    public static final ThreadLocal<Context> userThreadLocal = new ThreadLocal<Context>();

    public static void set(Context user) {
        userThreadLocal.set(user);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static Context get() {
        return (Context) userThreadLocal.get();
    }
}
