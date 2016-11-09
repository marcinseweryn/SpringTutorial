package pl.spring.module2.service;

import java.util.List;

import pl.spring.module2.model.Task;

public interface ToDoListStrategy {

	public List<Task> createToDoList();

}