//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.13 at 12:13:34 AM CST 
//


package snippets.jdk.jaxb.xjc.a1.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the snippets.jdk.jaxb.xjc.a1.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ExpenseReport_QNAME = new QName("", "expenseReport");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: snippets.jdk.jaxb.xjc.a1.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExpenseT }
     * 
     */
    public ExpenseT createExpenseT() {
        return new ExpenseT();
    }

    /**
     * Create an instance of {@link UserT }
     * 
     */
    public UserT createUserT() {
        return new UserT();
    }

    /**
     * Create an instance of {@link ItemT }
     * 
     */
    public ItemT createItemT() {
        return new ItemT();
    }

    /**
     * Create an instance of {@link ItemListT }
     * 
     */
    public ItemListT createItemListT() {
        return new ItemListT();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExpenseT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "expenseReport")
    public JAXBElement<ExpenseT> createExpenseReport(ExpenseT value) {
        return new JAXBElement<ExpenseT>(_ExpenseReport_QNAME, ExpenseT.class, null, value);
    }

}
