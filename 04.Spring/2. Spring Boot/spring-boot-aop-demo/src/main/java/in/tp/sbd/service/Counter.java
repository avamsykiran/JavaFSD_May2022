package in.tp.sbd.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Counter {

	private int seed;
	
	public int next() {
		return ++seed;
	}
}
