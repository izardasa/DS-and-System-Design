package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortObjectsTest {

	public static Predicate<Person> isMale(){
		return p->p.isMale();
	}
	
	public static Predicate<Person> isAdult(){
		return p->p.getAge()>=21;
	}
	
	public static Predicate<Person> isFemale(){
		return p->!p.isMale();
	}
	
	public static List<Person> filterPerson(List<Person> person,Predicate<Person> predicate){
		
		return person.stream().filter(predicate).collect(Collectors.toList());
	}
	
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

		filterPerson(filterPerson(person,isFemale()),isAdult()).forEach(System.out::println);
		//person.forEach(System.out::println);
		System.out.println();
		
		/*Comparator<Person> comparatorById = (p1,p2)->p1.getAge()-p2.getAge();
		Collections.sort(person,comparatorById);
		person.forEach(System.out::println);
		System.out.println();
		
		Comparator<Person> comparatorByFirstNameThenLastName = Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName);
		Collections.sort(person,comparatorByFirstNameThenLastName);
		person.forEach(System.out::println);
		
		
		
		StringJoiner joiner = new StringJoiner(",","","");
		StringJoiner stringJoiner1 = joiner.add("sanjay").add("is").add("a").add("developer").add("of").add("efi");
		System.out.println(stringJoiner1.toString());*/
		
	}

}
