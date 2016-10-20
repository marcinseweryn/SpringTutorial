package pl.spring.module2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.spring.module2.configuration.ApplicationConfiguration;

public class Runner {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		AbstractApplicationContext applicationContext = (AbstractApplicationContext) context;
		applicationContext.registerShutdownHook();
		
		TaskService taskService = context.getBean(TaskService.class);

		String serviceId = taskService.getServiceId();

		
		System.out.println("Id serwisu to: " + serviceId);
		
	}

}
