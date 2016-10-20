package pl.spring.module2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;

@Component
// @Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TaskService {

	public String getServiceId() {
		return "taskService#1";
	}

	@PostConstruct
	public void init() {
		System.out.println("pozyskiwanie zasobow");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("zwalnianie zasobow");
	}
}
