package pl.spring.module2.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pl.spring.module2.model.Task;

@Service
public class TaskService {

	private ToDoListStrategy toDoListStrategy;

	private String serviceId;
	
	public String getServiceId() {
		return serviceId;
	}

	public TaskService(){
		
	}
	
	public TaskService(ToDoListStrategy toDoListStrategy, String serviceId) {
		super();
		this.toDoListStrategy = toDoListStrategy;
		this.serviceId = serviceId;
	}

	public List<Task> findCurrentToDo() {
		
		List<Task> toDoList = toDoListStrategy.createToDoList();
	
		return toDoList;
	}

}
