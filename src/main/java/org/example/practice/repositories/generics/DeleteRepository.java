package org.example.practice.repositories.generics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteRepository<Entity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public void delete(Entity entity) {
        try {
            if (!entityManager.contains(entity)) {
                entity = entityManager.merge(entity);
            }
            entityManager.remove(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}