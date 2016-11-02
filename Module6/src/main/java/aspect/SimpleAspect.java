package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

	@Before(value = "allBeans() && args(subject,startDate,closeDate)", argNames = "subject,startDate,closeDate")
	public void befor(String subject, String startDate, String closeDate) {

		//Signature signature = joinPoint.getSignature();
		//String name = signature.getName();

		/*
		 * Object[] args = joinPoint.getArgs(); for (int i = 0; i < args.length;
		 * i++) { System.out.println("Parametr " + args[i]); }
		 */

		System.out.println("Subject " + subject);
		System.out.println("Start " + startDate);
		System.out.println("Close " + closeDate);

		//System.out.println("Przed wywo³aniem metody " + name);
	}

	@Pointcut(value = "bean(*)")
	public void allBeans() {

	}

	@Pointcut(value = "within(*..*Service)")
	public void onlyServices() {

	}

}
