package design.pattern.decorator.a2.after;

public class BasicMobilePayment implements Payment {
    private double moneyPerMinute;
    
    public BasicMobilePayment(double moneyPerMinute){
        this.moneyPerMinute = moneyPerMinute;
    }
    
    public double charge(User user, int minute) {
        return minute * moneyPerMinute;
    }
}