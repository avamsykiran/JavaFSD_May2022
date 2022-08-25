package in.tp.sbd.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.tp.sbd.service.Counter;
import in.tp.sbd.service.GreetService;

@Component
public class HomeUI implements CommandLineRunner{
	
	@Value("${app.title:This is my first spring core application}")
	private String appTitle;
	
	@Autowired
	private Scanner scan;

	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService gs1;
	
	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService gs2;
	
	@Autowired
	@Qualifier("greetServiceMultiLingualImpl")
	private GreetService gs3;
	
	@Autowired
	@Qualifier("greetServiceMultiLingualImpl2")
	private GreetService gs4;
	
	@Autowired
	private Counter c1;

	@Autowired
	private Counter c2;
	
	@Autowired
	private Counter c3;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(appTitle);
		System.out.println("----------------------------------------------");
		
		System.out.println("User Name? ");
		String userName = scan.nextLine();
		
		System.out.println(gs1.greet(userName));
		System.out.println(gs2.greet(userName));
		System.out.println(gs3.greet(userName));
		System.out.println(gs4.greet(userName));
		
		System.out.println(c1.next());
		System.out.println(c2.next());
		System.out.println(c3.next());
	}
}
