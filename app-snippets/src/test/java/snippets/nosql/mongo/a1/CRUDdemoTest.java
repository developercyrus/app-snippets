package snippets.nosql.mongo.a1;

import org.junit.Assert;
import org.junit.Test;

import com.mongodb.BasicDBObject;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

public class CRUDdemoTest {

	@Test
	public void test() throws Exception {
		int port = 12345;		
		MongodStarter runtime = MongodStarter.getDefaultInstance();
		MongodConfig mongodConfig = new MongodConfig(Version.Main.PRODUCTION, port, Network.localhostIsIPv6());
		MongodExecutable mongodExecutable = runtime.prepare(mongodConfig);
	    mongodExecutable.start();
	    
	    
	    CRUDdemo demo = new CRUDdemo();
	    BasicDBObject student1 = new BasicDBObject();  
	    student1.put("name", "jack");  
        BasicDBObject courses = new BasicDBObject();  
        courses.put("1", "History");  
        courses.put("2", "English");  
        student1.put("courses", courses);  

	    demo.saveData(student1);
	    String actual = demo.findData(student1).get("name").toString();
	    Assert.assertEquals("jack", actual);
	    
	    
	    BasicDBObject newCourses = new BasicDBObject();  
	    newCourses.put("1", "Chinese");  
	    newCourses.put("2", "Maths");  

	    demo.updateData(student1, "courses", newCourses);
	    demo.showData();
	    
	    mongodExecutable.stop();
	}



}
