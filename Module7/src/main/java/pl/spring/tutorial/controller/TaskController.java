package pl.spring.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.spring.tutorial.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/all-tasks", method=RequestMethod.GET)
	public String allTasks(Model model){
		
		model.addAttribute("allTasks", taskService.findAllTasks());
		
		return "all-tasks";
	}
	
}
