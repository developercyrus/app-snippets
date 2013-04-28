package design.pattern.builder.a1.after;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final String phone;
    private final String cellphone;

    private Person(PersonalInfoBuilder builder) {
        System.out.println("3");
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
        this.cellphone = builder.cellphone;
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
    
    public static class PersonalInfoBuilder implements Builder<Person> {
        private String firstName = "";
        private String lastName = "";
        private int age = 0;
        private String address = "";
        private String phone = "";
        private String cellphone = "";

        public PersonalInfoBuilder firstName(String firstName) {
            System.out.println("1");
            this.firstName = firstName;
            return this;
        }

        public PersonalInfoBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonalInfoBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonalInfoBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonalInfoBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersonalInfoBuilder cellphone(String cellphone) {
            this.cellphone = cellphone;
            return this;
        }

        @Override
        public Person build() {
            System.out.println("2");
            return new Person( this );
        }
    }
}