package pl.spring.module2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pl.spring.module2.model.Task;

@Repository
@RepositoryQualifier(type=RepositoryType.JPA)
public class JpaTaskRepository implements TaskRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveTask(Task task) {
		
	}

	public List<Task> findAllTask() {

		Query createQuery = entityManager.createQuery("from Task");
		return createQuery.getResultList();
	}

}
