package pl.spring.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Library {

	@Autowired
	public StudentListService studentListService;

	public void registerNewStudent(String name) {
		if (!studentListService.isStudent(name)) {
			throw new IllegalArgumentException("No such student [name=" + name + "]");
		}
	}
	@Value("${hours}")
	private String openingHours;
	
	public String openingHours(){
		return openingHours;
	}
}
