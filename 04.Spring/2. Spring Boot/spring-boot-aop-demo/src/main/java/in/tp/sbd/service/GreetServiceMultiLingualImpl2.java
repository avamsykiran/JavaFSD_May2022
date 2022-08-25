package in.tp.sbd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultiLingualImpl2 implements GreetService{
	
	@Value("#{${greetings.list}}")
	private List<String> greetings;

	@Override
	public String greet(String userName) {
		StringBuffer greeting=new StringBuffer();
		
		for(String greet : greetings)
			greeting.append("\n"+greet+" "+userName);
		
		return greeting.toString();
	}

}
