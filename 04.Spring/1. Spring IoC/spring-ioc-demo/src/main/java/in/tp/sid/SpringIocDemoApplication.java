package in.tp.sid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.tp.sid.ui.HomeUI;

public class SpringIocDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		System.out.println(context.getBean("today"));
		
		HomeUI ui = (HomeUI) context.getBean("homeUI");
		ui.run();
	}

}
