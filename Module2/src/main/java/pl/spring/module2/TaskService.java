package pl.spring.module2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;

//@Component
public class TaskService implements InitializingBean,DisposableBean {

	public String getServiceId() {
		return "taskService#1";
	}

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct pozyskiwanie zasobow");
	}

	@PreDestroy
	public void destroyService() {
		System.out.println("PreDestroy zwalnianie zasobow");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean pozyskiwanie zasobow");	
	}

	public void destroy() throws Exception {
		System.out.println("DisposableBean zwalnianie zasobow");	
	}
	
	public void initMethod(){
		System.out.println("init method");
	}
	
	public void destroyMethod(){
		System.out.println("destroy method");
	}
	
	public void defaultInitMethod(){
		System.out.println("default init method");
	}
	
	public void defaultDestroyMethod(){
		System.out.println("default destroy method");
	}
}
