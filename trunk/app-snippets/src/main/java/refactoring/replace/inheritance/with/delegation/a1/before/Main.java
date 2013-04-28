package refactoring.replace.inheritance.with.delegation.a1.before;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random dice = new Dice();
        System.out.println(dice.nextInt());
        /*
         * this violates Liskov substitution principle, 
         * Child (Dice) cannot operate as normal as parent (Random)
         */
        System.out.println(dice.nextDouble());
    }
}
