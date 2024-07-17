package org.example.practice.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class BaseRepository<Entity> {

    private final Class<Entity> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseRepository(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    public Entity create(Entity entity) {
        try {
            entityManager.persist(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Entity> getAll() {
        try {
            return entityManager.createQuery("from " + entityClass.getName(), entityClass).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Entity findById(int id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Entity update(Entity entity) {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
