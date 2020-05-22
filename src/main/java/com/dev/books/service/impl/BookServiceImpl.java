package com.dev.books.service.impl;

import com.dev.books.dao.BookDao;
import com.dev.books.lib.Injector;
import com.dev.books.lib.Service;
import com.dev.books.model.Author;
import com.dev.books.model.Book;
import com.dev.books.model.Genre;
import com.dev.books.service.BookService;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private static final Injector INJECTOR = Injector.getInstance("com.dev.books");
    private static BookDao bookDao = (BookDao) INJECTOR.getInstance(BookDao.class);

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookDao.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGender(Genre genre) {
        return bookDao.getBooksByGender(genre);
    }
}
