package repository;


import model.Task;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Singleton
public class TaskDAO {

    @PersistenceContext (unitName = "testPersistenceUnit")
    private EntityManager entityManager;

    @Transactional
    public void saveTask (Task task) {
        entityManager.persist(task);
    }

    public Collection <Task> getTasks () {
        Query query = entityManager.createQuery("SELECT u FROM Task u");

        return  query.getResultList();
    }

    public Task getTask (Long taskId) {
        return entityManager.find(Task.class, taskId);
    }

    @Transactional
    public void mergeTask (Task task) {
        entityManager.merge(task);
    }

}
