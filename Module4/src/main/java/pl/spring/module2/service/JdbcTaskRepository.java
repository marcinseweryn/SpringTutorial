package pl.spring.module2.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pl.spring.module2.model.Task;

@Repository
@RepositoryQualifier(type=RepositoryType.JDBC)
public class JdbcTaskRepository implements TaskRepository {

	private SimpleJdbcInsert taskInsert;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcTaskRepository(DataSource dataSource) {
		taskInsert = new SimpleJdbcInsert(dataSource).withTableName("task");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveTask(Task task) {
		Map<String, Object> params = task.NewMap().subject().startDate().closeDate().bulid();

		taskInsert.execute(params);

	}
	
	public List<Task> findAllTask(){
		return jdbcTemplate.query("SELECT * FROM task;", new TaskMapper());
	}
	
	public class TaskMapper implements RowMapper<Task>{

		public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Task task = Task.New().withId(rs.getLong("Id"))
					.withSubject(rs.getString("Subject"))
					.startsOn(new java.util.Date(rs.getDate("Start_date").getTime()))
					.closedOn(new java.util.Date(rs.getDate("Close_date").getTime()))
					.build();					
			
			return task;
		}
		
	}
}
