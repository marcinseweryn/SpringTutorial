package pl.spring.tutorial.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.ModelAndViewAssert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;



import pl.spring.tutorial.model.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TaskControllerBehaviour {

	@Autowired
	TaskController controler;
	
	@Test
	public void should_return_task_list_and_task_form_command() throws Exception {
		MockHttpServletRequest req = new MockHttpServletRequest("GET","/all-tasks");
		
		AnnotationMethodHandlerAdapter adapter = new AnnotationMethodHandlerAdapter();
		
		ModelAndView handle = adapter.handle(req,new MockHttpServletResponse(),controler);
		
		assertAndReturnModelAttributeOfType(handle, "allTasks",List.class);
		assertAndReturnModelAttributeOfType(handle, "task",Task.class);
		
	}

}
