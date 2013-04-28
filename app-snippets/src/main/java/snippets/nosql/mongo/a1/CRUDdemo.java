package snippets.nosql.mongo.a1;

import java.net.UnknownHostException;
import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class CRUDdemo {
	private final DBCollection coll;
	
	public CRUDdemo () throws UnknownHostException {
		Mongo mongo = new Mongo("localhost", 12345);
		// if database doesn't exists, MongoDB will create it for you
	    DB db = mongo.getDB("test");
	    // if collection doesn't exists, MongoDB will create it for you
		coll = db.getCollection("user");
	}
	
	
	public void saveData(BasicDBObject obj) {  
        coll.insert(obj);  
    }  
	
	public DBObject findData(BasicDBObject query) {  
		DBCursor cur = coll.find(query);    
		Iterator<DBObject> it = cur.iterator();   
        return it.next();
    } 
	
	public void updateData(BasicDBObject query, String param, BasicDBObject updatedValue){  
		DBObject beingUpdated = coll.findOne(query); 
		beingUpdated.put(param, updatedValue);		
		coll.update(query, beingUpdated);  
    } 
	
	public void showData(){ 
		DBCursor cur = coll.find();    
		Iterator it = cur.iterator();   
        while(it.hasNext()) {    
            System.out.println(it.next());    
        }    
	}    
}
