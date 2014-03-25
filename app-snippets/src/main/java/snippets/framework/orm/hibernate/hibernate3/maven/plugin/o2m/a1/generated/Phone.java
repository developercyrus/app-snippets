package snippets.framework.orm.hibernate.hibernate3.maven.plugin.o2m.a1.generated;
// Generated Mar 25, 2014 11:15:49 PM by Hibernate Tools 3.2.4.GA



/**
 * Phone generated by hbm2java
 */
public class Phone  implements java.io.Serializable {


     private Integer id;
     private Student student;
     private String number;

    public Phone() {
    }

	
    public Phone(Student student) {
        this.student = student;
    }
    public Phone(Student student, String number) {
       this.student = student;
       this.number = number;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }




}


