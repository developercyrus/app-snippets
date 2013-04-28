package design.pattern.decorator.a1;

public class Developer implements Human {
    private Human human;

    public Developer(Human human) {
        this.human = human;
    }

    public String getJob() {
        return "In software house " + this.human.getJob();
    } 
}