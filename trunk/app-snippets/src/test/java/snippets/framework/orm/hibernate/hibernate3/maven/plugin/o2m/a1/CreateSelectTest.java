package snippets.framework.orm.hibernate.hibernate3.maven.plugin.o2m.a1;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import snippets.framework.orm.hibernate.hibernate3.maven.plugin.o2m.a1.generated.Phone;
import snippets.framework.orm.hibernate.hibernate3.maven.plugin.o2m.a1.generated.Student;

public class CreateSelectTest {
    @Test
    public void test() {
        Session session = HibernateUtil.currentSession();
        session.beginTransaction();
        
        Set<Phone> phones = new HashSet<Phone>();
        
        Student student = new Student();
        Phone phone1 = new Phone(student, "999");
        Phone phone2 = new Phone(student, "888");        
        phones.add(phone1);
        phones.add(phone2); 
        
        student.setName("peter");
        student.setPhones(phones);  
        
        session.save(student);
        session.save(phone1);
        session.save(phone2);
        
        session.getTransaction().commit();
        
        String sql = "select s.name, p.number from student s inner join phone p on s.id = p.student_id";
        SQLQuery query = session.createSQLQuery(sql);
        List<Object[]> list = query.list();
        for (Object[] record : list) {
            System.out.println(record[0] + ", " + record[1]);
        }
    }
}
