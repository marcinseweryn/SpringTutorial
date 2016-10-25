package pl.spring.module2;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.spring.module2.service.TaskService;

public class Runner {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

		TaskService taskService = context.getBean(TaskService.class);

		taskService.addTask("Zadanie 200", "2016-12-24", "2016-12-25");
			
		System.out.println(taskService.findAllTasks());
	}

}
