package in.tp.jpahibdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emps")
public class Employee implements Comparable<Employee> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String fullName;
	private Double salary;
	
	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
	private Laptop laptop;
	
	@ManyToOne
	private Department dept;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Long empId, String fullName, Double salary, Address address, Laptop laptop, Department dept) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
		this.address = address;
		this.laptop = laptop;
		this.dept = dept;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public int compareTo(Employee o) {
		return this.empId==null?-1:this.empId.compareTo(o.empId);
	}
}
