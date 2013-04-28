package design.pattern.decorator.a1;

public class Main {
    public static void main(String args[]) {
        Human james = new James();
        Human decoreatedJames = new Soldier(new Developer(new Teacher(james)));
        System.out.println(decoreatedJames.getJob());
    }

}