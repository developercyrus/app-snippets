package snippets.cache.distributed.memcached.a1.server;

import java.net.InetSocketAddress;

import com.thimbleware.jmemcached.CacheImpl;
import com.thimbleware.jmemcached.Key;
import com.thimbleware.jmemcached.LocalCacheElement;
import com.thimbleware.jmemcached.MemCacheDaemon;
import com.thimbleware.jmemcached.storage.CacheStorage;
import com.thimbleware.jmemcached.storage.hash.ConcurrentLinkedHashMap;

public class MemcachedServer {
    private final MemCacheDaemon<LocalCacheElement> daemon = new MemCacheDaemon<LocalCacheElement>();
    
    public MemcachedServer() {
        int maxItems = 1024;
        long maxBytes = 1024 * 2048;
        CacheStorage<Key, LocalCacheElement> storage = ConcurrentLinkedHashMap.create(ConcurrentLinkedHashMap.EvictionPolicy.FIFO, maxItems, maxBytes);
        daemon.setCache(new CacheImpl(storage));        
        daemon.setAddr(new InetSocketAddress("localhost", 11211));
        daemon.setBinary(false);
        daemon.setVerbose(true);
    }
    
    public void start() {
        daemon.start();
    }
    
    public void stop() {
        daemon.stop();
    }
}