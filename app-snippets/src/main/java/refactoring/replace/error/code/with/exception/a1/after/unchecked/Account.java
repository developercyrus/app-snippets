package refactoring.replace.error.code.with.exception.a1.after.unchecked;

public class Account {
    private int balance;
    
    public Account(int balance) {
        this.balance = balance;
    }
    
    public void withdraw(int amount) {
        if (amount > this.balance) 
            // extends RuntimeException, and it should be a programming bug
            throw new IllegalArgumentException("Amount too large");
        this.balance -= amount;
    }
}
