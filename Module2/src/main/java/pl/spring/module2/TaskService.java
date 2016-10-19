package pl.spring.module2;

import org.springframework.stereotype.Component;

@Component("myService")
public class TaskService {

	public String getServiceId() {
		return "taskService#1";
	}
}
