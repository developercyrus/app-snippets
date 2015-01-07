package snippets.cache.distributed.memcached.a1.client;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

public class Client {
    public static void create(String key, int expiration, Object o) {               
        try {
            MemcachedClient mc = new MemcachedClient(new InetSocketAddress("localhost", 11211));
            Future<Boolean> b = mc.set(key, expiration, o);
            if(b.get().booleanValue()==true){
                mc.shutdown();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static Object get(String key) {  
        Object o = null;
        try {
            MemcachedClient mc = new MemcachedClient(new InetSocketAddress("localhost", 11211));
            o = mc.get("neea:testDaF:ksIdno");
            mc.shutdown();            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return o;
    }
    
    
}
