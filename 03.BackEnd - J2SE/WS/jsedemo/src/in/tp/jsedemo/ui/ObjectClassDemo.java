package in.tp.jsedemo.ui;

import in.tp.jsedemo.model.Employee;
import in.tp.jsedemo.model.Gender;

public class ObjectClassDemo {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee(101,"Vamsy",Gender.MALE,6789);
		Employee e4 = e1;
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		System.out.println(e4.hashCode());
	
		System.out.println(e1==e2);
		System.out.println(e1.equals(e2));
		System.out.println(e1==e3);
		System.out.println(e1.equals(e3));
		System.out.println(e1==e4);
		System.out.println(e1.equals(e4));
		
	}

}
