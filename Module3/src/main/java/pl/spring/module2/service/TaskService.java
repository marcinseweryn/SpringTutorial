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

	@Autowired
	@ToDoListQualifier(strategy=ToDoListType.EISENHOWER)
	private ToDoListStrategy toDoListStrategy;
	@Resource
	private ApplicationContext context;
	@Value("${serviceId.default}")
	private String serviceId;
	
	public String getServiceId() {
		return serviceId;
	}

	public List<Task> findCurrentToDo() {
		toDoListStrategy = (ToDoListStrategy) context.getBean("defaultToDoListStrategy");
		
		List<Task> toDoList = toDoListStrategy.createToDoList();
	
		return toDoList;
	}

}
