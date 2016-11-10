package pl.spring.tutorial.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRepository implements TaskRepository {

	public Map<Long,Task> storedTasks = new HashMap<Long, Task>();
	
	private Long nextId;
	
	@PostConstruct
	public void init() throws ParseException{
		nextId=1L;
		saveTask(Task.addTask("Zadanie 200", "2016-12-24", "2016-12-25"));
		saveTask(Task.addTask("Zadanie 201", "2016-12-24", "2016-12-25"));
		
	}

	
	public void saveTask(Task task) {
		System.out.println("Dodano zadanie "+task.getSubject());
		storedTasks.put(nextId,task);
		nextId++;	
	}
	
	public List<Task> findAllTasks() {	
		return new ArrayList<Task>(storedTasks.values());
	}
	
	
}
