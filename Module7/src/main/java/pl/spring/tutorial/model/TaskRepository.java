package pl.spring.tutorial.model;

import java.util.List;

public interface TaskRepository{
	
	public abstract void saveTask(Task task);
	
	public abstract List<Task> findAllTasks();


}