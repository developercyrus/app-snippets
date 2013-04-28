package snippets.unit.testing.fest.list.a1;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
    public boolean equals(Object o) {
		Person x = (Person) o;
		if (x.name == this.name && x.age == this.age) 		
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
}
