package refactoring.replace.error.code.with.exception.a1.after.checked;

public class Account {
    private int balance;
    
    public Account(int balance) {
        this.balance = balance;
    }
    
    public void withdraw(int amount) throws InsufficentException {
        if (amount > this.balance) 
            throw new InsufficentException(amount);
        this.balance -= amount;
    }
}
