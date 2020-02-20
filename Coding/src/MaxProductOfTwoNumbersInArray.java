import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MaxProductOfTwoNumbersInArray {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList();
		employees.add(new Employee("Sanjay", 34, 35000));
		employees.add(new Employee("Raju", 36, 5000));
		employees.add(new Employee("Aryan", 31, 32000));
		employees.add(new Employee("Vinita", 32, 55000));
		
		employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
		.limit(3)
		.map(Employee::getName)
		.forEach(System.out::println);
				
		
	}

	private static void findMaxProduct(int[] A) {
		HashMap<String, Integer> hm= new HashMap<>();
		List<String> str =new ArrayList<>();
		
	}

}

class Employee
{
	String name;
	int age;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	int salary;
	
	public Employee(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	
}
