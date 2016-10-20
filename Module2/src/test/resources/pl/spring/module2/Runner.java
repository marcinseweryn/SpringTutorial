package pl.spring.module2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.spring.module2.configuration.ApplicationConfiguration;

public class Runner {

	public static void main(String[] args) {

		ApplicationContext contex = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		TaskService taskService = contex.getBean("serviceAlias", TaskService.class);

		String serviceId = taskService.getServiceId();

		System.out.println("Id serwisu to: " + serviceId);
	}

}
