package in.tp.jpahibdemo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	private String deptName;
	
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
	private Set<Employee> employees;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Long deptId, String deptName, Set<Employee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.employees = employees;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
