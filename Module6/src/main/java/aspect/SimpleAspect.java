package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {
	
	@Before(value = "bean(*)")
	public void befor(JoinPoint joinPoint){
		
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		
		System.out.println("Przed wywo³aniem metody "+name);
	}
	
	@Around(value = "bean(*)")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		System.out.println("przed");
		
		Object proceed = proceedingJoinPoint.proceed();

		System.out.println("po");
		
		return proceed;
	}
	
}
