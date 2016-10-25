package pl.spring.module2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.module2.model.Task;

@Repository
@RepositoryQualifier(type=RepositoryType.JPA)
public class JpaTaskRepository implements TaskRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveTask(Task task) {	
		entityManager.persist(task);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Task> findAllTask() {
		Query createQuery = entityManager.createQuery("from Task");
		return createQuery.getResultList();
	}

}
