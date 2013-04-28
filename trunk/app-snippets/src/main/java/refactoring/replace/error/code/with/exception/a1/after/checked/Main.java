package refactoring.replace.error.code.with.exception.a1.after.checked;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(500);
        try {
            account.withdraw(800);
        } catch (InsufficentException e) {
            System.out.println("You are short of " + e.getAmount());
        }
        
    }
}
