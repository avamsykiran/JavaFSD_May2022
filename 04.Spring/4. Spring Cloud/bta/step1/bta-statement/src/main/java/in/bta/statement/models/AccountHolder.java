package in.bta.statement.models;

public class AccountHolder {
	
	private long ahId;
	private String fullName;
	private String mobile;
	private String mailId;
	private double currentBalacne;
	
	public AccountHolder() {
		// TODO Auto-generated constructor stub
	}

	public AccountHolder(long ahId, String fullName, String mobile, String mailId, double currentBalacne) {
		super();
		this.ahId = ahId;
		this.fullName = fullName;
		this.mobile = mobile;
		this.mailId = mailId;
		this.currentBalacne = currentBalacne;
	}

	public long getAhId() {
		return ahId;
	}

	public void setAhId(long ahId) {
		this.ahId = ahId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public double getCurrentBalacne() {
		return currentBalacne;
	}

	public void setCurrentBalance(double currentBalacne) {
		this.currentBalacne = currentBalacne;
	}

		
}
