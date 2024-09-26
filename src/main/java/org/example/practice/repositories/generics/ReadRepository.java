package org.example.practice.repositories.generics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReadRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<T> getAll(Class<T> entityClass) {
        try {
            return entityManager.createQuery("from " + entityClass.getName(), entityClass)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public T findById(Class<T> entityClass, int id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}