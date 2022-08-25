package in.tp.sbd.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greet(String userName) {
		return "Hello " + userName;
	}

}
