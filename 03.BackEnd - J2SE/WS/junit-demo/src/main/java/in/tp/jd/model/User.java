package in.tp.jd.model;

import java.time.LocalDate;

public class User {

	private String fullName;
	private	LocalDate daeOfbirth;
	private Gender gender;
	
	public User(){
		
	}

	public User(String fullName, LocalDate daeOfbirth, Gender gender) {
		super();
		this.fullName = fullName;
		this.daeOfbirth = daeOfbirth;
		this.gender = gender;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDaeOfbirth() {
		return daeOfbirth;
	}

	public void setDaeOfbirth(LocalDate daeOfbirth) {
		this.daeOfbirth = daeOfbirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
