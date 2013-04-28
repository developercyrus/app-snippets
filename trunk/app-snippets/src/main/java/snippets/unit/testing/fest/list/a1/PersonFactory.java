package snippets.unit.testing.fest.list.a1;

import java.util.Arrays;
import java.util.List;

public class PersonFactory {
	private final List<Person> persons;
	
	public PersonFactory() {
		Person sam = new Person("Sam", 31);
		Person john = new Person("John", 32);
		persons = Arrays.asList(sam, john);				
	}
	
	public List<Person> getPersons() {
		return persons;
	}
}
