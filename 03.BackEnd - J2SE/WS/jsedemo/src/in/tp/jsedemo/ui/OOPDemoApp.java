package in.tp.jsedemo.ui;

import in.tp.jsedemo.model.Circle;
import in.tp.jsedemo.model.ContractEmployee;
import in.tp.jsedemo.model.Employee;
import in.tp.jsedemo.model.Gender;
import in.tp.jsedemo.model.Manager;
import in.tp.jsedemo.model.Rectangle;

public class OOPDemoApp {

	public static void main(String[] args) {
		Employee emp = new Employee(101, "Vamsy Kirna", Gender.MALE, 55000);
		System.out.println(emp);
		
		Manager mgr = new Manager(102, "Srinu", Gender.MALE, 76000, 4000);
		System.out.println(mgr);
		
		ContractEmployee cemp = new ContractEmployee(103, "Sagarika", Gender.FEMALE, 45000, 5.3);
		System.out.println(cemp);
		
		Rectangle r = new Rectangle();
		r.setLength(10);
		r.setBreadth(20);
		System.out.println(r.estimatePaintingCost(10));
		
		Circle c = new Circle();
		c.setRadius(4);
		System.out.println(c.estimatePaintingCost(10));
	}

}
