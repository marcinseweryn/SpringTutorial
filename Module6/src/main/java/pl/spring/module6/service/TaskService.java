package pl.spring.module6.service;


import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.module6.Util;
import pl.spring.module6.model.Task;
import pl.spring.module6.model.TaskRepository;

@Service
public class TaskService{
	
	@Autowired
	private TaskRepository repository;
	
	public void addTask(String subject, String startDate, String closeDate ) throws ParseException{
		
		Task task = Task.New().withSubject(subject)
				.startsOn(Util.createDate(startDate))
				.closedOn(Util.createDate(closeDate))
				.build();
		
		repository.saveTask(task);
	}	

	public List<Task> findAllTasks() {
		return repository.findAllTasks();
	}

}
