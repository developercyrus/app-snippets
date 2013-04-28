package design.pattern.builder.a1.before;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final String phone;
    private final String cellphone;

    public Person(String firstName, String lastName, int age, String address, String phone, String cellphone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.cellphone = cellphone;
    }
    
    public Person(String firstName, String lastName, int age, String address, String phone) {
        this(firstName, lastName, age, address, phone, ""); 
    }
    
    public Person(String firstName, String lastName, int age, String address) {
        this(firstName, lastName, age, address, "", ""); 
    }
    
    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, "", "", ""); 
    }
    
    public Person(String firstName, String lastName) {
        this(firstName, lastName, 0, "", "", ""); 
    }
    
    public Person(String firstName) {
        this(firstName, "", 0, "", "", ""); 
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCellphone() {
        return cellphone;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }    
}