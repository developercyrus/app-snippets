package snippets.components.scanner.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;

import net.sf.extcos.ComponentQuery;
import net.sf.extcos.ComponentScanner;

public class ByExtcos { 
    public static String[] getClassName() {
        List<String> l = new ArrayList<String>();
        
        ComponentScanner scanner = new ComponentScanner();

        Set<Class<?>> classes = scanner.getClasses(new ComponentQuery() {
            protected void query() {
                select().from("snippets.apache.commons.beanutils.a1");                
            }
        });

        for (Class<?> c : classes) {
            l.add(c.getName());           
        }
        
        String[] c = new String[l.size()];
        return (String[])l.toArray(c); 
    }

    public static String[] getAnnotatedClassName() {
        List<String> l = new ArrayList<String>();
        
        ComponentScanner scanner = new ComponentScanner();

        Set<Class<?>> classes = scanner.getClasses(new ComponentQuery() {
            protected void query() {
                select().from("snippets.framework.junit.annotation.a1").returning(allAnnotatedWith(Ignore.class));     
            }
        });

        for (Class<?> c : classes) {
            l.add(c.getName());           
        }
        
        String[] c = new String[l.size()];
        return (String[])l.toArray(c); 
    }
}
