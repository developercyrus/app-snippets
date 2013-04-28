package design.pattern.flyweight.a1.after;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Ralph", "Alice", "Sam"};
        int[] ids = {1001, 1002, 1003};
        int[] scores = {45, 55, 65};

        double total = 0;
        for (int i=0; i<scores.length; i++) {
            total += scores[i];
        }
        double averageScore = total / scores.length;

        /*
         *  this is flyweight object
         *  
         *  by extracting generics from those massive objects, and relying on runtime configuration 
         *  to minic those massive objects, and in turn save resources
         *  
         *  Otherwise 3 individual student have to created. 
         *  It will be resouces-demanding if student number is over 10,000 or larger 
         */
        Student student = new Student(averageScore);
        
        for (int i=0; i<names.length; i++) {
            student.setId(ids[i]);
            student.setName(names[i]);
            student.setScore(scores[i]);

            System.out.println("Name: " + student.getName());
            System.out.println("Standing: " + Math.round(student.getStanding()));
            System.out.println();         
        }        
    }
}
