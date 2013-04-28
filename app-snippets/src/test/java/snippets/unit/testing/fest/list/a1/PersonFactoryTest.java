package snippets.unit.testing.fest.list.a1;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class PersonFactoryTest {
	@Test
	public void test() {
		PersonFactory pf = new PersonFactory();
		List<Person> persons = pf.getPersons();
		Person sam = new Person("Sam", 31);
		Person john = new Person("John", 32);

		//by fest
		assertThat(persons).isNotEmpty()
							.hasSize(2)
							.contains(sam, john);
		
		//by junit
		assertTrue(persons.contains(sam));
		assertTrue(persons.contains(john));
	}
	
	public static void main(String[] args) {
		PersonFactory pf = new PersonFactory();
		List<Person> persons = pf.getPersons();
		Person sam = new Person("Sam", 31);
		Person john = new Person("John", 32);
		
		System.out.println(persons.contains(sam));
		System.out.println(persons.contains(john));	
		
		assertThat(persons).isNotEmpty()
							.hasSize(2)
							.contains(sam, john);
	}
}
