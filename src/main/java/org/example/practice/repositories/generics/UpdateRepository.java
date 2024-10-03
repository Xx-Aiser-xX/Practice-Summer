package org.example.practice.repositories.generics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateRepository<Entity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public void update(Entity entity) {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}