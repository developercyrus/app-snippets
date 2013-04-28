package snippets.jdk.exception.a2;

public class CleanUpException extends Exception {
    private static final long serialVersionUID = -3996314313413350455L;
    private String mistake;

    public CleanUpException() {
        super();             // call superclass constructor
        mistake = "Clean Up Exception";
        System.out.println(mistake);
    }

    public CleanUpException(String err) {
        super(err);     // call super class constructor
        mistake = err;  // save message
    }

    public String getError() {
        return mistake;
    }
}
