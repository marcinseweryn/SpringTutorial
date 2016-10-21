package pl.spring.module2.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import pl.spring.module2.model.Task;

@Service
@ToDoListQualifier(strategy=ToDoListType.DEFAULT)
public class DefaultToDoListStrategy implements ToDoListStrategy{

	public List<Task> createToDoList() {
		List<Task> toDoList = new ArrayList<Task>();
		
		toDoList.add(new Task(1L));
		toDoList.add(new Task(2L));
		toDoList.add(new Task(3L));

		return toDoList;
	}
}
