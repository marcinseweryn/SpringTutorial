package pl.spring.tutorial.service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.spring.tutorial.model.Student;


@Repository
@StudentQualifier(studentType=StudentType.JPA)
public class JpaStudentList implements StudentList {

@Autowired
@Qualifier(value = "sessionFactory")
private SessionFactory sessionFactory;
	
	public boolean isStudent(String name) {
		boolean isStudent = false;
		
		List<?> list = sessionFactory.openSession()
				.createCriteria(Student.class)
				.add(Restrictions.eq("name",name))
				.list();
		if(list.size()>0){
			isStudent=true;
		}
		
		return isStudent;
	}

}
