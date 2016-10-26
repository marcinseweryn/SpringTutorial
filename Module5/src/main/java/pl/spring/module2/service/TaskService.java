package pl.spring.module2.service;


import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import pl.spring.module2.model.Task;
import pl.spring.module2.model.TaskRepository;
import java.util.Date;


@Service
public class TaskService implements TaskRepository {
		
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private Validator validator;
	
	public void addTask(String subject,Date startDate, Date closeDate ) throws ParseException{
		
		Task task = Task.New().withId(1l)
				.withSubject(subject)
				.startsOn(startDate)
				.closedOn(closeDate)
				.build();			
		repository.saveTask(task);
		
		Errors errors = new BindException(task, "task");
		validator.validate(task, errors);
		
		for (FieldError error : errors.getFieldErrors()) {		
			System.out.println(errors);
		}
	}

	public void saveTask(Task task) {
		
	}

}
