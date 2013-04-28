package design.pattern.strategy.a2.before;

public class Dwarve extends Character {
    public Dwarve(String name) {
        super(name, 150, 50);
    }
    @Override
    public void attack() {
        System.out.println("Axe attack");
    }
}