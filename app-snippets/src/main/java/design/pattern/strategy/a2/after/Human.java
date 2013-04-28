package design.pattern.strategy.a2.after;

public class Human extends Character {
    public Human(String name, AttackBehavior attackBehavior) {
        super(name, 100, 100, attackBehavior);
    }
    
    @Override
    public void attack() {
        System.out.println("Sword attack");
    }
}