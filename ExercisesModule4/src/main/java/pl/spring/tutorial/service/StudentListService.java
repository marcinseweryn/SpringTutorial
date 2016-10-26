package pl.spring.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentListService {

	@Autowired
	@StudentQualifier(studentType = StudentType.JPA)
	StudentList studentList;

	public boolean isStudent(String name) {
		return studentList.isStudent(name);
	}
}
