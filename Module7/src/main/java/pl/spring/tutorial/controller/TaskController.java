package pl.spring.tutorial.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.spring.tutorial.model.Task;
import pl.spring.tutorial.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/all-tasks", method=RequestMethod.GET)
	public String allTasks(Model model){
		
		model.addAttribute("allTasks", taskService.findAllTasks());
		Task task = new Task();
		task.setSubject("temat");
		model.addAttribute("task", task);
		
		return "all-tasks";
	}
	
	@RequestMapping(value="/all-tasks", method=RequestMethod.POST)
	public String saveTask(@Valid Task task, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "all-tasks";
		}
		
		taskService.addTask(task);
		
		return "redirect:/all-tasks";
	}
	
}
