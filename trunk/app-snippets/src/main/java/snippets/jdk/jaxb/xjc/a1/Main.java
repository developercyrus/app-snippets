package snippets.jdk.jaxb.xjc.a1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import snippets.jdk.jaxb.xjc.a1.generated.ExpenseT;
import snippets.jdk.jaxb.xjc.a1.generated.ItemListT;
import snippets.jdk.jaxb.xjc.a1.generated.ItemT;
import snippets.jdk.jaxb.xjc.a1.generated.ObjectFactory;
import snippets.jdk.jaxb.xjc.a1.generated.UserT;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws JAXBException {

        ObjectFactory factory = new ObjectFactory();

        UserT user = factory.createUserT();
        user.setUserFirstName("Sanaulla");
        ItemT item = factory.createItemT();
        item.setItemName("Seagate External HDD");
        item.setPurchasedOn("August 24, 2010");
        item.setAmount(new BigDecimal("6776.5"));

        ItemListT itemList = factory.createItemListT();
        itemList.getItem().add(item);

        ExpenseT expense = factory.createExpenseT();
        expense.setUser(user);
        expense.setItems(itemList);

        JAXBContext context = JAXBContext.newInstance("snippets.xml.jaxb.b.generated");
        JAXBElement<ExpenseT> element = factory.createExpenseReport(expense);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
        marshaller.marshal(element, System.out);
    }
}
