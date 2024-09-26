package org.example.practice.repositories.generics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateRepository<Entity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public Entity update(Entity entity) {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}