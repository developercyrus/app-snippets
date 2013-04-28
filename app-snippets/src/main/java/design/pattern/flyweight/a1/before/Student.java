package design.pattern.flyweight.a1.before;

public class Student {
    private String name;
    private int id;
    private int score;
    private double averageScore;
    
    public Student(String name, int id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
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
    
    public double getAverageScore() {
        return averageScore;
    }


    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
    
    public double getStanding() {
        return (((double)score) / averageScore - 1.0) * 100.0;
    }
}
