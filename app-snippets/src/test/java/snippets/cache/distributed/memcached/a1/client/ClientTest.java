package snippets.cache.distributed.memcached.a1.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import snippets.cache.distributed.memcached.a1.server.MemcachedServer;

public class ClientTest {
    @Test
    public void method1() {
        MemcachedServer ms = new MemcachedServer();
        ms.start();
        
        String key = "neea:testDaF:ksIdno";
        int expiration = 900;
        String expected = "someObject";
        
        Client.create(key, expiration, expected);
        String actual = (String) Client.get(key);
        System.out.println(actual);
        ms.stop();
        
        assertEquals(expected, actual);
    }
}
