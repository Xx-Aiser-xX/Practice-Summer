package org.example.practice.repositories.generics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class CreateRepository<Entity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public Entity create(Entity entity) {
        try {
            entityManager.persist(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}