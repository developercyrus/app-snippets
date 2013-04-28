package design.pattern.decorator.a1;

public class Soldier implements Human {
    private Human human;

    public Soldier(Human human) {
        this.human = human;
    }

    public String getJob() {
        return "In amry " + this.human.getJob();
    }

}