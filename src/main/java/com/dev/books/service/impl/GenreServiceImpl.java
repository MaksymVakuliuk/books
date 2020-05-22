package com.dev.books.service.impl;

import com.dev.books.dao.GenreDao;
import com.dev.books.lib.Injector;
import com.dev.books.lib.Service;
import com.dev.books.model.Genre;
import com.dev.books.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
    private static final Injector INJECTOR = Injector.getInstance("com.dev.books");
    private static GenreDao genreDao = (GenreDao) INJECTOR.getInstance(GenreDao.class);
    
    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }
}
