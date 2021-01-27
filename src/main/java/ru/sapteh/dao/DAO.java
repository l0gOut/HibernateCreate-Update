package ru.sapteh.dao;

import java.util.List;

public interface DAO<Entity, Key> {

    void create (Entity entity);
    void update (Entity entity);
    void delete (Entity entity);
    List<Entity> readAll ();
    Entity read (Key key);

}
