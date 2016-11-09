package pl.spring.module2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.spring.module2.model.Task;
import pl.spring.module2.service.TaskService;

public class Runner {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"META-INF/spring/app-context.xml",
						"META-INF/spring/app-context-strategies.xml"});

		TaskService taskService = context.getBean(TaskService.class);

		String serviceId = taskService.getServiceId();
		List<Task> toDoList = taskService.findCurrentToDo();

		System.out.println("Id serwisu to: " + serviceId);
		System.out.println(toDoList);

	}

}
