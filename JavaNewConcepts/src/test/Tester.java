package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		List<Person> person = Arrays.asList(
				new Person("Rajesh", "Kurashi", 30,true), 
				new Person("Arjun", "Biharu", 32,true),
				new Person("Arjun", "Bau", 20,true), 
				new Person("Arjun", "Malik", 40,true), 
				new Person("Arjun", "Ehirman", 35,true),
				new Person("Arjun", "Izardar", 30,true), 
				new Person("Khusi", "Dansena", 32,false),
				new Person("Lalima", "Patel", 20,false), 
				new Person("Akansha", "Sharama", 40,false), 
				new Person("Ravinfra", "Jadeja", 35,true));


		// Sort list by last name
		Collections.sort(person, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {

				return p1.getLastName().compareTo(p2.getLastName());
			}

		});

		// Create a method that prints all elements in the list
		System.out.println("Print all persons");
		printAll(person);
		System.out.println();
		// Create a method that prints all people that have last name begining
		// with C
		// printNameBeginingWithC(person);

		System.out.println("Print all persons whose last name starts with B");
		printNameConditionally(person, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("B");
			}

		});
		System.out.println();

		System.out.println("Print all persons whose last name starts with K");
		printNameConditionally(person, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("K");
			}

		});
		System.out.println();
	}

	private static void printNameConditionally(List<Person> person, Condition condition) {
		for (Person p : person) {
			if (condition.test(p))
				System.out.println(p);
		}

	}

	private static void printNameBeginingWithC(List<Person> person) {
		for (Person p : person) {
			if (p.getLastName().startsWith("B"))
				System.out.println(p);
		}

	}

	private static void printAll(List<Person> person) {
		for (Person p : person)
			System.out.println(p);

	}

}

interface Condition {
	boolean test(Person p);
}
