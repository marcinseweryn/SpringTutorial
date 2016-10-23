package pl.spring.module2.service;


import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	private String serviceId;
	
	public String getServiceId() {
		return serviceId;
	}
}
