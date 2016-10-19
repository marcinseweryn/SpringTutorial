package pl.spring.module2;

import javax.inject.Named;

@Named("serwis")
public class TaskService {

	public String getServiceId() {
		return "taskService#1";
	}
}
