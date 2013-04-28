package design.pattern.strategy.a2.after;

public class SwordAttackBehavior implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Sword attack");
    }
}