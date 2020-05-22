package com.dev.books.dao.impl;

import com.dev.books.dao.GenreDao;
import com.dev.books.lib.Dao;
import com.dev.books.model.Genre;
import com.dev.books.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre add(Genre genre) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(genre);
            transaction.commit();
            return genre;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert Genre", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
