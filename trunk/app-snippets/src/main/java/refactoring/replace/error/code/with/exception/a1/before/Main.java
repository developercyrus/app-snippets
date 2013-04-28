package refactoring.replace.error.code.with.exception.a1.before;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(500);
        System.out.println(account.withdraw(800));        
    }
}
