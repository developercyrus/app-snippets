package snippets.jdk.lang.exception.custom.a1;

public class BadDataSetException extends Exception {
    private static final long serialVersionUID = -2043309311331000143L;
    private final String mistake;

    public BadDataSetException() {
        super();             
        mistake = "Bad Data Set";
        System.out.println(mistake);
    }

    public BadDataSetException(String err) {
        super(err);     
        mistake = err;  
    }

    public String getError() {
        return mistake;
    }
}
