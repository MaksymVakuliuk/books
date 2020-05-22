package com.dev.books.dao.impl;

import com.dev.books.dao.BookDao;
import com.dev.books.lib.Dao;
import com.dev.books.model.Author;
import com.dev.books.model.Book;
import com.dev.books.model.Genre;
import com.dev.books.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert Book", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Can't get Books by title", e);
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Can't get Books by Author", e);
        }
    }

    @Override
    public List<Book> getBooksByGender(Genre genre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Can't get Books by Genre", e);
        }
    }
}
