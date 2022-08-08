package in.tp.jpahibdemo;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import in.tp.jpahibdemo.entity.Address;
import in.tp.jpahibdemo.entity.Department;
import in.tp.jpahibdemo.entity.Employee;
import in.tp.jpahibdemo.entity.Laptop;

public class App2 {

	public static void main(String[] args) {

		Department d1 = new Department(null, "Sales", null);
		Department d2 = new Department(null, "Accounts", null);
		Department d3 = new Department(null, "HR", null);
		
		Employee e1 = new Employee(null, "Srinu", 75000.0, new Address("flat#1234", "VSP"), new Laptop(null, "I7Dell", null), d1);
		Employee e2 = new Employee(null, "Deepa", 85000.0, new Address("flat#4567", "VSP"), new Laptop(null, "I9Dell", null), d1);
		Employee e3 = new Employee(null, "Vamsy", 65000.0, new Address("flat#3455", "VSP"), new Laptop(null, "I5Dell", null), d2);
		Employee e4 = new Employee(null, "Suseela", 85000.0, new Address("flat#5566", "VSP"), new Laptop(null, "I5Dell", null), d2);
		Employee e5 = new Employee(null, "Abhi", 95000.0, new Address("flat#1122", "VSP"), new Laptop(null, "I6Dell", null), d3);
		
		e1.getLaptop().setOwner(e1);
		e2.getLaptop().setOwner(e2);
		e3.getLaptop().setOwner(e3);
		e4.getLaptop().setOwner(e4);
		e5.getLaptop().setOwner(e5);
		
		d1.setEmployees(Set.of(e1,e2));
		d2.setEmployees(Set.of(e3,e4));
		d3.setEmployees(Set.of(e5));
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		EntityTransaction tran =  em.getTransaction();
		tran.begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		tran.commit();
		em.close();
	}

}
