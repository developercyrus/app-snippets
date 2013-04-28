package design.pattern.composite.a3;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {
    private String name;
    private double salary;
    private List<Employee> employees;
    
    public Manager(String name, double salary) {
        this.employees = new ArrayList<Employee>();
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
        System.out.println("Manager " + name + " Salary: $" + salary);
        for(Employee e : employees) {
            e.print(indent + 2);
        }
    }
    
    public void add(Employee employee) {
        employees.add(employee);
    }
}
