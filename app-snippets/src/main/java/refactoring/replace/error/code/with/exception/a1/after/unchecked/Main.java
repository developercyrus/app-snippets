package refactoring.replace.error.code.with.exception.a1.after.unchecked;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(500);
        account.withdraw(800);        
    }
}
