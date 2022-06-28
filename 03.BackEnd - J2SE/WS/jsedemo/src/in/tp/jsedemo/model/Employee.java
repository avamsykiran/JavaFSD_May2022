package in.tp.jsedemo.model;

public class Employee {
	private int empId;
	private String fullName;
	private Gender gender;
	private double basic;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String fullName, Gender gender, double basic) {
		this.empId = empId;
		this.fullName = fullName;
		this.gender = gender;
		this.basic = basic;
	}
	
	public Employee(Employee emp) {
		this(emp.empId,emp.fullName,emp.gender,emp.basic);
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "empId=" + empId + ", fullName=" + fullName + ", gender=" + gender + ", basic=" + basic;
	}
	
	
}
