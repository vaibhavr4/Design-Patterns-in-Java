package sorters;

public class Person implements Comparable<Person> {
	
	String name;
	public Person(String name) {
		setName(name);
	}

	void setName(String name) {
		this.name=name;
	}
	String getName() {
		return this.name;
		
	}
	@Override
	public int compareTo(Person p) {
		return this.getName().compareTo(p.getName());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Person)) {
			return false;
		}
		Person p = (Person) o;
		return this.getName().equals(p.getName());
	}

}
