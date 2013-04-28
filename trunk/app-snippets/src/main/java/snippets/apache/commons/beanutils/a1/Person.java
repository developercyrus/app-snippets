package snippets.apache.commons.beanutils.a1;

import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Person {
    private String name;
    private int age;
    private Date date;

    public Person(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        try {
            return BeanUtils.describe(this).toString();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<?, ?> toMap() {
        try {
            return BeanUtils.describe(this);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

