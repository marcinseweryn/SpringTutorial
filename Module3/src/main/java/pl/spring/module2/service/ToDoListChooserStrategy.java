package pl.spring.module2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.spring.module2.model.Task;

@Service
public class ToDoListChooserStrategy {

	public List<Task> createToDoList() {
		return new ArrayList<Task>();
	}
}
