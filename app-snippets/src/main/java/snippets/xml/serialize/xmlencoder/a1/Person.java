package snippets.xml.serialize.xmlencoder.a1;

import java.util.List;

public class Person {
    private boolean isMale;
    private String firstName;
    private List<String> phones;
    
    public boolean isMale() {
        return isMale;
    }
    
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
