package pl.spring.tutorial.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
@StudentQualifier(studentType=StudentType.JDBC)
public class JdbcStudentList implements StudentList{

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcStudentList(DataSource dataSource ) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	
	public boolean isStudent(String name) {
		boolean isStudent = false;
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT * FROM STUDENTS "
					+ "WHERE name=?",name);
		if(rowSet.next()){
			isStudent = true;
		}
			
		return isStudent;
	}

}
