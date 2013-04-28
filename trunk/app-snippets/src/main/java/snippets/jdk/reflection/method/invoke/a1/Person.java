package snippets.jdk.reflection.method.invoke.a1;

public class Person {
    private String firstname;
    private String lastname = "Chan";

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getFullname() {
        return firstname + " " + lastname;
    }
}
