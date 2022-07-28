package in.tp.jd.service;

import java.util.Map;
import java.util.TreeMap;

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
	
	public String greetIn(String userName,String lang) {
		String greeting=greetings.get(lang);
		
		return greeting!=null?greeting +" " + userName:null;
	}
}
