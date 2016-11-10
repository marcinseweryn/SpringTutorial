package pl.spring.tutorial.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/WEB-INF/spring/root-context.xml"})
public class TaskControllerBehaviour {

	@Test
	public void should_return_task_list_and_task_form_command() {
	
	}

}
