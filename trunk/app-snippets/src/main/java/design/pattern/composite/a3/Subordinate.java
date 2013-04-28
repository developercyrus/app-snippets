package design.pattern.composite.a3;

public class Subordinate implements Employee{
    private String name;
    private double salary;
    
    public Subordinate(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void print(int indent) {
        for (int i=0; i<indent; i++) {
            System.out.print(" ");
        }
        System.out.println("Employee " + name + " Salary: $" + salary);
    }
}