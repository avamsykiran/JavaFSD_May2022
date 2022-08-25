package in.tp.sbd.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Before("execution(* in.tp.sbd.service.*.*(..))")
	public void beforeServiceMethod(JoinPoint jp) {
		System.out.println("we are about to invoke "+jp);
	}
	
	@After("execution(* in.tp.sbd.service.*.*(..))")
	public void afterServiceMethod(JoinPoint jp) {
		System.out.println("we have invoked "+jp);
	}
}
