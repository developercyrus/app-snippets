package snippets.version.control.svn.svnkit.a1;

import java.util.Map;
import java.util.TreeMap;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNPropertyValue;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class CalculateCheckInDelta {

    public static void main(String[] args) throws SVNException {

        String urlStr = "https://app-snippets.googlecode.com/svn/trunk/";
        String username = "";
        String password = "";

        DAVRepositoryFactory.setup();
        SVNURL url = SVNURL.parseURIEncoded(urlStr);
        SVNRepository repos = SVNRepositoryFactory.create(url);
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username, password);
        repos.setAuthenticationManager(authManager);

        System.out.println("repos.getLocation() = " + repos.getLocation());
        long latestRevision = repos.getLatestRevision();
        System.out.println("repos.getLatestRevision() = " + latestRevision);
        
        Map<String, Integer> m = new TreeMap<String, Integer>();
        SVNPropertyValue p = null;
        String key = null;
        for (long i=1; i<=latestRevision; i++) {
            p = repos.getRevisionPropertyValue(i, "svn:date");
            key = p.toString().substring(0, 10);
            if (m.containsKey(key)) {
                Integer value = m.get(key);
                m.put(key, new Integer(value.intValue()+1));
            }
            else {
                m.put(key, new Integer(1));
            }  
            System.out.println(i + " " + key);
        }
        
        
        for (Map.Entry<String, Integer> e : m.entrySet()) {  
            System.out.println(e.getKey() + ":" + e.getValue());  
        }  
        
    }

}
