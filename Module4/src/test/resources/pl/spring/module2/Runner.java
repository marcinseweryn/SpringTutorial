package pl.spring.module2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import pl.spring.module2.model.Task;
import pl.spring.module2.service.TaskService;

public class Runner {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

		TaskService taskService = context.getBean(TaskService.class);

		DataSource dataSource = context.getBean(DataSource.class);

			System.out.println(dataSource);
			Connection connection = dataSource.getConnection();
			Statement createStatement = connection.createStatement();
			createStatement.execute("SELECT * FROM task");

		
	}

}
