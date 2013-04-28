package snippets.framework.di.spring.why.coupled.tightly;

import java.io.PrintStream;

public class MessageDestination {
    public void write(PrintStream out, String message) {
        out.println(message);
    }
}
