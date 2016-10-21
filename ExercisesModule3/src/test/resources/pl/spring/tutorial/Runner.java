package pl.spring.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.spring.tutorial.service.Library;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

		Library library = context.getBean(Library.class);
		
		System.out.println("Godziny otwarcia: "+library.openingHours());
		library.registerNewStudent("Marek");		
	}

}
