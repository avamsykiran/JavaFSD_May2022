package in.tp.jpahibdemo;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import in.tp.jpahibdemo.entity.Department;
import in.tp.jpahibdemo.entity.Employee;

public class App3 {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		EntityTransaction tran = em.getTransaction();
		
		TypedQuery<Department> qry1 =  em.createQuery("Select d from Department d", Department.class);
		qry1.getResultStream().forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------------------------------------------");
		
		TypedQuery<String> qry2 =  em.createQuery("select d.deptName from Department d", String.class);
		qry2.getResultStream().forEach(System.out::println);

		System.out.println("-------------------------------------------------------------------------------------------");
		
		TypedQuery<Employee> qry3 = em.createQuery("select e from Employee e where e.salary between :lb and :ub",Employee.class);
		qry3.setParameter("lb", 45000.0);
		qry3.setParameter("ub", 65000.0);
		qry3.getResultStream().forEach(System.out::println);

		System.out.println("-------------------------------------------------------------------------------------------");
		
		Query qry4 = em.createQuery("SELECT e.fullName,e.dept.deptName FROM Employee e");
		((Stream<Object[]>)qry4.getResultStream()).forEach(rec -> System.out.println(rec[0]+"\t"+rec[1]));
	
		System.out.println("-------------------------------------------------------------------------------------------");
		
	//	Query qry5 = em.createQuery("SELECT e.fullName,d.deptName FROM Department d inner join Employee e on e.dept");
	//	((Stream<Object[]>)qry5.getResultStream()).forEach(rec -> System.out.println(rec[0]+"\t"+rec[1]));
	
		em.close();
	}

}
