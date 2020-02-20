package test;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private boolean male;

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public Person(String firstName, String lastName, int age, boolean isMale) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.male = isMale;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString(){
		return "FirstName :"+firstName+" LastName: "+lastName+" Age:"+age;
	}
}
