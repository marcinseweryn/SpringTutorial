package pl.spring.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.spring.tutorial.service.StudentListService;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

		StudentListService listService = context.getBean(StudentListService.class);

		System.out.println(listService.isStudent("Smith"));

	}

}
