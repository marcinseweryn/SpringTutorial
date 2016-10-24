package pl.spring.module2.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pl.spring.module2.model.Task;

@Repository
public class TaskRepository {
	
	private SimpleJdbcInsert taskInsert;
	
	@Autowired
	public TaskRepository(DataSource dataSource){
		taskInsert = new SimpleJdbcInsert(dataSource).withTableName("task");
	}
	
	public void saveTask(Task task){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("Subject",task.getSubject());
		params.put("Start_date",new Date(task.getStartDate().getTime()));
		params.put("Close_date",new Date(task.getCloseDate().getTime()));
		System.out.println(task.toString());
		
		taskInsert.execute(params);
		
	}
}
