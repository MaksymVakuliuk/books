package com.dev.books.service.impl;

import com.dev.books.dao.AuthorDao;
import com.dev.books.lib.Injector;
import com.dev.books.lib.Service;
import com.dev.books.model.Author;
import com.dev.books.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final Injector INJECTOR = Injector.getInstance("com.dev.books");
    private static AuthorDao authorDao = (AuthorDao) INJECTOR.getInstance(AuthorDao.class);
    
    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }
}
