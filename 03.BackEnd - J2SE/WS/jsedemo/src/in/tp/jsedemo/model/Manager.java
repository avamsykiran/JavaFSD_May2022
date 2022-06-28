package in.tp.jsedemo.model;

public class Manager extends Employee {
	private double allowence;
	
	public Manager() {
		super();
	}

	public Manager(int empId, String fullName, Gender gender, double basic,double allowence) {
		super(empId, fullName, gender, basic);
		this.allowence=allowence;
	}

	public double getAllowence() {
		return allowence;
	}

	public void setAllowence(double allowence) {
		this.allowence = allowence;
	}
	
	@Override
	public String toString() {
		return super.toString() + ",allowence= "+allowence;
	}
}
