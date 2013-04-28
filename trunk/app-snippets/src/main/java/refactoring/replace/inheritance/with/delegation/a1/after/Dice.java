package refactoring.replace.inheritance.with.delegation.a1.after;

import java.util.Random;

public class Dice {
    private final Random random;
    
    public Dice() {
        this.random = new Random(314159L);
    }
    
    public int nextInt() {
        return this.random.nextInt(6) + 1;
    }
}
