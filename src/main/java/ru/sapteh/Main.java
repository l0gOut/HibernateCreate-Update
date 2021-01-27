package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Author;
import ru.sapteh.models.Genre;
import ru.sapteh.service.ServiceAuthor;
import ru.sapteh.service.ServiceGenre;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        DAO<Author, Long> serviceAuthor = new ServiceAuthor(factory);
        DAO<Genre, Long> serviceGenre = new ServiceGenre(factory);

        Author author = new Author();
        author.setFirstName("Albert");
        author.setLastName("Biden");
        author.setAge(34);

        Genre genre = serviceGenre.read((long)7);
//        genre.setGenre("fantasy");

        Set<Author> authorSet = new HashSet<>();
        authorSet.add(author);
        genre.setListAuthor(authorSet);

        Set<Genre> genreSet = new HashSet<>();
        genreSet.add(genre);
        author.setListGenre(genreSet);

        serviceAuthor.create(author);


        factory.close();

    }

}
