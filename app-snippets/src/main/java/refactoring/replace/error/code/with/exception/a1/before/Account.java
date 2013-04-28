package refactoring.replace.error.code.with.exception.a1.before;

public class Account {
    private int balance;
    
    public Account(int balance) {
        this.balance = balance;
    }
    
    public int withdraw(int amount) {
        if (amount > this.balance) { 
            return -1;
        }
        else {
            this.balance -= amount;
            return 0;
        }
    }
}
