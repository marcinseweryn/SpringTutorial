package pl.spring.module2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.module2.model.Task;

@Service
public class TaskService {

	@Autowired(required = true)
	private ToDoListStrategy toDoListChooser;

	public String getServiceId() {
		return "taskService#1";
	}

	public List<Task> findCurrentToDo() {
		List<Task> toDoList = toDoListChooser.createToDoList();
	
		return toDoList;
	}

}
