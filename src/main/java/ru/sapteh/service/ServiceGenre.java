package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Author;
import ru.sapteh.models.Genre;

import javax.persistence.Query;
import java.util.List;

public class ServiceGenre implements DAO<Genre, Long> {

    private final SessionFactory factory;

    public ServiceGenre(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(Genre genre) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(genre);
            session.getTransaction().commit();
        }
    }

    public void update(Genre genre) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(genre);
            session.getTransaction().commit();
        }
    }

    public void delete(Genre genre) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(genre);
            session.getTransaction().commit();
        }
    }

    public List<Genre> readAll() {
        try(Session session = factory.openSession()) {
            String hql = "FROM Role";
            return session.createQuery(hql).list();
        }
    }

    public Genre read(Long aLong) {
        try(Session session = factory.openSession()) {
            return session.get(Genre.class, aLong);
        }
    }
}
