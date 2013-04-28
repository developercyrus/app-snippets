package snippets.version.control.svn.svnkit.a1;


import org.joda.time.DateTime;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class DisplayRevisionDate {

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
        
        DateTime today = new DateTime();
        DateTime yesterday = today.minusDays(1);

        System.out.println(repos.getDatedRevision(today.toDate()));
        System.out.println(repos.getDatedRevision(yesterday.toDate()));    
    }

}
