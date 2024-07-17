package org.example.practice.Service;

import java.util.List;

public interface BaseService<Entity> {
    void create(Entity entity);
    List<Entity> getAll();
    Entity getById(int id);
    void update(Entity entity);
}