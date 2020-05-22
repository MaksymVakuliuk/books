package com.dev.books.dao;

import com.dev.books.model.Author;
import com.dev.books.model.Book;
import com.dev.books.model.Genre;
import java.util.List;

public interface BookDao {
    public Book add(Book book);

    public Book getBookByTitle(String title);

    public List<Book> getBooksByAuthor(Author author);

    public List<Book> getBooksByGender(Genre genre);
}
