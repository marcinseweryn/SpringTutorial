package pl.spring.tutorial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spring.tutorial.model.Task;
import pl.spring.tutorial.model.TaskRepository;

@Service
public class TaskService{
	
	@Autowired
	private TaskRepository repository;
	
	public void addTask(Task task ){
		repository.saveTask(task);
	}	

	public List<Task> findAllTasks() {
		return repository.findAllTasks();
	}

}
