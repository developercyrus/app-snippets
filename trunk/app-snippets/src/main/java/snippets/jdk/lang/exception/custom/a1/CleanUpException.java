package snippets.jdk.lang.exception.custom.a1;

public class CleanUpException extends Exception {
    private static final long serialVersionUID = 650899243664463590L;
    private final String mistake;

    public CleanUpException() {
        super();             
        mistake = "Clean Up Exception";
        System.out.println(mistake);
    }

    public CleanUpException(String err) {
        super(err);     
        mistake = err;  
    }

    public String getError() {
        return mistake;
    }
}
