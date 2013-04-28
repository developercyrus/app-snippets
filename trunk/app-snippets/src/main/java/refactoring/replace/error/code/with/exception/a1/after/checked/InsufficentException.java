package refactoring.replace.error.code.with.exception.a1.after.checked;

public class InsufficentException extends Exception {
    private int  amount;
    
    public InsufficentException(int amount) {
        this.amount = amount;
    } 

    public int getAmount() {
        return amount;
    }
}
