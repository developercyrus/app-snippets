package design.pattern.composite.a2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees1 = new ArrayList<Employee>();
        employees1.add(new Employee("Aaron", 15000));
        employees1.add(new Employee("Betty", 20000));
        Manager manager1 = new Manager(employees1, "Accounting");
        
        List<Employee> employees2 = new ArrayList<Employee>();
        employees2.add(new Employee("Cathy", 30000));
        employees2.add(new Employee("Dan", 40000));
        employees2.add(new Employee("Eliz", 50000));
        Manager manager2 = new Manager(manager1, employees2, "Production");
        
        List<Employee> employees3 = new ArrayList<Employee>();
        employees3.add(new Employee("Jeff", 60000));
        employees3.add(new Employee("Chris", 70000));
        employees3.add(new Employee("Alan", 80000));
        employees3.add(new Employee("Clifford", 90000));
        Manager manager3 = new Manager(manager2, employees3, "General");
        
        System.out.println(manager3.toString());
        List<Employee> e3 = manager3.getEmployees();
        for (Employee e : e3) {
            System.out.println("  "+ e.toString() + " Salary: $"+ e.getSalary());       
        }
        
        Manager m2 = manager3.getManager();
        System.out.println("  " + m2.toString());
        List<Employee> e2 = manager2.getEmployees();
        for (Employee e : e2) {
            System.out.println("    "+ e.toString() + " Salary: $"+ e.getSalary());       
        }
        
        Manager m1 = manager2.getManager();
        System.out.println("    " + m1.toString());
        List<Employee> e1 = m1.getEmployees();
        for (Employee e : e1) {
            System.out.println("      "+ e.toString() + " Salary: $"+ e.getSalary());       
        }
    }
}
