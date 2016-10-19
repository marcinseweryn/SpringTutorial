package pl.spring.module2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Runner {

	public static void main(String[] args) {

		ApplicationContext contex = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

		TaskService taskService = contex.getBean("serwis",TaskService.class);

		String serviceId = taskService.getServiceId();

		System.out.println("Id serwisu to: " + serviceId);
	}

}
