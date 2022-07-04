package in.tp.jsedemo.ui;

import in.tp.jsedemo.model.Employee;
import in.tp.jsedemo.model.Gender;
import in.tp.jsedemo.service.Swapper;

public class GenericsDemoApp {

	public static void main(String[] args) {

		Swapper<String> strSwapper = new Swapper<>();
		strSwapper.swap("Hello", "World");
		
		Swapper<Employee> empSwapper = new Swapper<>();
		empSwapper.swap(new Employee(101, "Vamsy", Gender.MALE, 23456), new Employee(102, "Srinu", Gender.MALE, 23456));
		
		Swapper<Integer> intSwapper = new Swapper<>();
		intSwapper.swap(1024, 512);
	}

}
