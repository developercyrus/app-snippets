package design.pattern.composite.a2;

import java.util.List;

public class Manager {
    private Manager manager;
    private List<Employee> employees;
    private String department;
    
    public Manager(Manager manager, List<Employee> employees, String department) {
        this(employees, department);
        this.manager = manager;
    }

    public Manager(List<Employee> employees, String department) {
        this.employees = employees;
        this.department = department;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public Manager getManager() {
        return manager;
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }
    
    public String toString() {
        return department + " manager";
    }
}
