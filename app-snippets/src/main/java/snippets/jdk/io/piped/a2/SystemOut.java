package snippets.jdk.io.piped.a2;

public class SystemOut implements Functional {
    @Override
    public void execute() {
        System.out.println("Hello World");
        System.out.println("Bye World");
    }
}
