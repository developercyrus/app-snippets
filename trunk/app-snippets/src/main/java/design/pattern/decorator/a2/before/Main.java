package design.pattern.decorator.a2.before;

public class Main {
    public static void main(String[] args) {
        // $1.2 per minute
        MobilePayment mobilePayment = new MobilePayment(1.2);
        User user1 = new User("Lawrence", true, false);
        User user2 = new User("Tony", false, false);
        User user3 = new User("ABC Company", false, true);
        
        System.out.println(user1.getName() + " usage: 10000 minute, charge: " + mobilePayment.charge(user1, 10000));
        System.out.println(user2.getName() + " usage: 10000 minute, charge: " + mobilePayment.charge(user2, 10000));
        System.out.println(user3.getName() + " usage: 10000 minute, charge: " + mobilePayment.charge(user3, 10000));
    }
}