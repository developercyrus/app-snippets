package snippets.framework.orm.hibernate.hibernate3.maven.plugin.o2m.a1.generated;
// Generated Apr 6, 2014 12:08:30 AM by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set phones = new HashSet(0);

    public Student() {
    }

    public Student(String name, Set phones) {
       this.name = name;
       this.phones = phones;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getPhones() {
        return this.phones;
    }
    
    public void setPhones(Set phones) {
        this.phones = phones;
    }




}


