package pl.spring.module2;


import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.spring.module2.service.TaskService;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

		TaskService taskService = context.getBean(TaskService.class);
		
		try {
			taskService.addTask("Zadanie","2016-10-24","2016-10-25");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
