package design.pattern.strategy.a2.after;

public class Dwarve extends Character {
    public Dwarve(String name, AttackBehavior attackBehavior) {
        super(name, 150, 50, attackBehavior);
    }
    
    @Override
    public void attack() {
        System.out.println("Axe attack");
    }
}