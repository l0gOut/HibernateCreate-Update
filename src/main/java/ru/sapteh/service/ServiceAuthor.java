package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Author;

import javax.persistence.Query;
import java.util.List;

public class ServiceAuthor implements DAO<Author, Long> {

    private final SessionFactory factory;

    public ServiceAuthor(SessionFactory factory){
        this.factory = factory;
    }

    public void create(Author author) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }
    }

    public void update(Author author) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(author);
            session.getTransaction().commit();
        }
    }

    public void delete(Author author) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
        }
    }

    public List<Author> readAll() {
        try(Session session = factory.openSession()) {
            String hql = "FROM Role";
            return session.createQuery(hql).list();
        }
    }

    public Author read(Long aLong) {
        try(Session session = factory.openSession()) {
            return session.get(Author.class, aLong);
        }
    }
}
