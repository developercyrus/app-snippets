package snippets.framework.orm.hibernate.hibernate3.maven.plugin.a1.generated;
// Generated Jan 7, 2015 4:20:47 PM by Hibernate Tools 3.2.4.GA



/**
 * Person generated by hbm2java
 */
public class Person  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
       this.name = name;
       this.age = age;
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
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }




}


