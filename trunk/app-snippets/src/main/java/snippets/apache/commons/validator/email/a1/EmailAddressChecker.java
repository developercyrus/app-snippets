package snippets.apache.commons.validator.email.a1;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailAddressChecker {
    public static void main(String[] args) {
        String email = "!#$%&'*+-/=?^_`{|}~@gmail.com";
        EmailValidator ev = EmailValidator.getInstance();
        System.out.println(ev.isValid(email));
    }    
    
    public static boolean check(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);        
    }
}
