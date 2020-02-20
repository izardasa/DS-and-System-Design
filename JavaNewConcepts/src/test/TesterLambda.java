package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TesterLambda {

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
		Collections.sort(person, (p1,p2)->p1.getLastName().compareTo(p2.getLastName()));

		// Create a method that prints all elements in the list
		System.out.println("Print all persons");
		printNameConditionally(person,p->true,p->System.out.println(p));
		System.out.println();
		// Create a method that prints all people that have last name begining
		// with C
		// printNameBeginingWithC(person);

		System.out.println("Print all persons whose last name starts with B");
		printNameConditionally(person, p->p.getLastName().startsWith("B"),p->System.out.println(p));
		System.out.println();

		System.out.println("Print all persons whose last name starts with K");
		printNameConditionally(person, p->p.getLastName().startsWith("K"),p->System.out.println(p));
		System.out.println();
	}

	private static void printNameConditionally(List<Person> person, Predicate<Person> condition, Consumer<Person> consumer) {
		for (Person p : person) {
			if (condition.test(p))
				consumer.accept(p);
		}

	}

	
}


