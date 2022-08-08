package in.tp.jpahibdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import in.tp.jpahibdemo.entity.EducationLoan;
import in.tp.jpahibdemo.entity.GeneralPurposeLoan;
import in.tp.jpahibdemo.entity.HomeLoan;

public class App1 {

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		EntityTransaction tran =  em.getTransaction();
		tran.begin();
		em.persist(new GeneralPurposeLoan(12345L, 45000.0, 12.0, 12.0));
		em.persist(new HomeLoan(23456L, 500000.0, 7.0, 180.0, 600000.0));
		em.persist(new EducationLoan(45678L, 250000.0, 3.0, 5.0, "BTech"));
		tran.commit();
		em.close();
	}

}
