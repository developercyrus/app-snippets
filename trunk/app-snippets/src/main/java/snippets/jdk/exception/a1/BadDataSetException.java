package snippets.jdk.exception.a1;

public class BadDataSetException extends Exception {
    private static final long serialVersionUID = -5685122040255849262L;
    private String mistake;

    public BadDataSetException() {
        super();             // call superclass constructor
        mistake = "Bad Data Set";
        System.out.println(mistake);
    }

    public BadDataSetException(String err) {
        super(err);     // call super class constructor
        mistake = err;  // save message
    }

    public String getError() {
        return mistake;
    }
}
