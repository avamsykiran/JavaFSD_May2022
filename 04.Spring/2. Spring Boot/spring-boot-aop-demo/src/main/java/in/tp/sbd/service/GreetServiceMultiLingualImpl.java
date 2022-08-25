package in.tp.sbd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultiLingualImpl implements GreetService{
	
	@Value("${greetings.array}")
	private String[] greetings;

	@Override
	public String greet(String userName) {
		StringBuffer greeting=new StringBuffer();
		
		for(String greet : greetings)
			greeting.append("\n"+greet+" "+userName);
		
		return greeting.toString();
	}

}
