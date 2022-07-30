 package in.tp.jd.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.TreeMap;

import in.tp.jd.exception.InvalidUserException;
import in.tp.jd.model.Gender;
import in.tp.jd.model.User;

public class GreetService {

	Map<String,String> greetings;
	
	public GreetService() {
		greetings = new TreeMap<>();
		greetings.put("en", "Hello");
		greetings.put("hi", "Namaskar");
		greetings.put("te", "Namaskaram");
		greetings.put("tm", "Vanakkam");
	}
	
	public String greet(String userName) {
		return "Hello " + userName;
	}
	
	public String greetUser(User user) throws InvalidUserException {
		if(user==null)
			throw new InvalidUserException();
		
		int age = Period.between(user.getDaeOfbirth(), LocalDate.now()).getYears();
		
		String title="";
		if(user.getGender()==Gender.LADY) {
			if(age<=12) {
				title="Baby. ";
			} else {
				title="Ms. ";
			}
		}else {
			if(age<=12) {
				title="Master. ";
			} else {
				title="Mr. ";
			}
		}
			
		return greet(title + user.getFullName());
	}
	
	public String greetIn(String userName,String lang) {
		String greeting=greetings.get(lang);
		
		return greeting!=null?greeting +" " + userName:null;
	}
}
