package in.tp.jsedemo.ui;

import java.util.Set;
import java.util.TreeSet;

import in.tp.jsedemo.model.Employee;
import in.tp.jsedemo.model.Gender;
import in.tp.jsedemo.service.EmployeeGenderComparator;

public class SetDemoApp {

	public static void main(String[] args) {

		//Set<Employee> emps = new HashSet<>();
		//Set<Employee> emps = new LinkedHashSet<>();
		//Set<Employee> emps = new TreeSet<>();
		//Set<Employee> emps = new TreeSet<>(new EmployeeFullNameComparator());
		Set<Employee> emps = new TreeSet<>(new EmployeeGenderComparator());
		
		emps.add(new Employee(112, "Vamsy Kiran", Gender.MALE, 4567));
		emps.add(new Employee(105, "Srinivas", Gender.MALE, 4867));
		emps.add(new Employee(199, "Abhishek", Gender.MALE, 8567));
		emps.add(new Employee(111, "Sagar", Gender.MALE, 2567));
		emps.add(new Employee(113, "Indhikaa", Gender.FEMALE, 4597));
		emps.add(new Employee(118, "Suseela", Gender.FEMALE, 4507));
		emps.add(new Employee(197, "Vinay", Gender.MALE, 6567));
		emps.add(new Employee(777, "Vinodh", Gender.MALE, 1567));
		emps.add(new Employee(333, "Anjalai", Gender.FEMALE, 5967));
		emps.add(new Employee(212, "Anupama", Gender.FEMALE, 4500));

		System.out.println(emps.size());
		for (Employee e : emps)
			System.out.println(e);
	}

}
