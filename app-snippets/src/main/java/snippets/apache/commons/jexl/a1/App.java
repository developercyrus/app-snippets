package snippets.apache.commons.jexl.a1;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

public class App {
    public static String getValue(String exp, double val) throws Exception {
        // Create or retrieve a JexlEngine
        JexlEngine jexl = new JexlEngine();
        // Create an expression object
        String jexlExp = exp;
        Expression e = jexl.createExpression(jexlExp);

        // Create a context and add data
        JexlContext jc = new MapContext();
        jc.set("x", val);

        // Now evaluate the expression, getting the result
        Object o = e.evaluate(jc);
        return o.toString();
    }
}
