package pl.spring.tutorial;

import org.springframework.stereotype.Component;

@Component
public class Library {
 
	public String openingHours(){
		return "9:00 - 17:00";
	}
	
	public boolean isOpen(){
		return true;
	}
}
