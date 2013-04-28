package design.pattern.flyweight.a1.after;

public class Student {
    private String name;
    private int id;
    private int score;
    private double averageScore;
    
    public Student(double averageScore) {
        this.averageScore = averageScore;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public double getStanding() {
        return (((double)score) / averageScore - 1.0) * 100.0;
    }
}
