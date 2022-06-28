package in.tp.jsedemo.ui;

import in.tp.jsedemo.model.ContractEmployee;
import in.tp.jsedemo.model.Employee;
import in.tp.jsedemo.model.Gender;
import in.tp.jsedemo.model.Manager;

public class OOPDemoApp {

	public static void main(String[] args) {
		Employee emp = new Employee(101, "Vamsy Kirna", Gender.MALE, 55000);
		System.out.println(emp);
		
		Manager mgr = new Manager(102, "Srinu", Gender.MALE, 76000, 4000);
		System.out.println(mgr);
		
		ContractEmployee cemp = new ContractEmployee(103, "Sagarika", Gender.FEMALE, 45000, 5.3);
		System.out.println(cemp);
		
	}

}
