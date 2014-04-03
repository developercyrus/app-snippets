package snippets.jee.jndi.junitjndi.a1.server;

import javax.naming.Context;
import javax.naming.NamingException;

import junitjndi.JndiRule;

public class JndiServer extends JndiRule {
    @Override
    protected void bind(Context context) throws NamingException {
        context.bind("someobj", new Object());
        context.bind("somestring", "abc");
        
        Context cx = context.createSubcontext("java:/comp/env");
        cx.bind("jdbc/mysql", "MysqlDatasource");
    }


}
