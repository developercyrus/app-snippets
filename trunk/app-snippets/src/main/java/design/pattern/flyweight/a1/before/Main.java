package design.pattern.flyweight.a1.before;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {       
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Ralph", 1001, 45));
        students.add(new Student("Alice", 1002, 55));
        students.add(new Student("Sam", 1003, 65));

        double total = 0;
        for (Student student : students) {
            total += student.getScore();
        }
        double averageScore = total / students.size();

        for (Student student : students) {
            student.setAverageScore(averageScore);
            System.out.println("Name: " + student.getName());
            System.out.println("Standing: " + Math.round(student.getStanding()));
            System.out.println();         
        }        
    }
}
