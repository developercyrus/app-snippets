package design.pattern.strategy.a2.after;

public class AxeAttackBehavior implements AttackBehavior {
    @Override
    public void attack() {
        System.out.println("Axe attack");
    }
}
