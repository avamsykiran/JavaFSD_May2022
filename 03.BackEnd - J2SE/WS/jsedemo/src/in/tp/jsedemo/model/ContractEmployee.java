package in.tp.jsedemo.model;

public class ContractEmployee extends Employee {
	private double contractDuration;
	
	public ContractEmployee() {
		super();
	}

	public ContractEmployee(int empId, String fullName, Gender gender, double basic,double contractDuration) {
		super(empId, fullName, gender, basic);
		this.contractDuration=contractDuration;
	}

	public double getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(double contractDuration) {
		this.contractDuration = contractDuration;
	}

	@Override
	public String toString() {
		return super.toString() + ",contractDuration= "+contractDuration;
	}
}
