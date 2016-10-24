package pl.spring.module2.service;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spring.module2.model.Task;
import pl.spring.module2.Util;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public void addTask(String subject, String startDate, String closeDate ) throws ParseException{
		
		Task task = Task.New().withSubject(subject)
				.startsOn(Util.createDate(startDate))
				.closedOn(Util.createDate(closeDate))
				.build();
		
		repository.saveTask(task);
	}
	

}
