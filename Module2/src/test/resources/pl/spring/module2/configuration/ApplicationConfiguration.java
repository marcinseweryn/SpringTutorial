package pl.spring.module2.configuration;

import org.springframework.context.annotation.Bean;

import pl.spring.module2.TaskService;

public class ApplicationConfiguration {

	@Bean(name={"myService","serviceAlias"})
	public TaskService taskService(){
		return new TaskService();
	}
	
}
