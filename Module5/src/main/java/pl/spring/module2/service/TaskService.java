package pl.spring.module2.service;


import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	
	@Autowired
	private MessageSource messageSource;
	
	public void addTask(String subject,Date startDate, Date closeDate ) throws ParseException{
		
		Task task = Task.New().withId(null)
				.withSubject(subject)
				.startsOn(startDate)
				.closedOn(closeDate)
				.build();			
		repository.saveTask(task);
		
		Errors errors = new BindException(task, "task");
		validator.validate(task, errors);
		
		for (FieldError error : errors.getFieldErrors()) {		
			String errorCode = formatErrorCode(error);
			
			String message = messageSource.getMessage(errorCode, null, new Locale("pl"));
			System.out.println(message);
			
		}
	}

	private String formatErrorCode(FieldError error) {
		
		return error.getCode() + "." + error.getObjectName() + "." + error.getField();
	}

	public void saveTask(Task task) {
		
	}

}
