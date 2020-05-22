package com.dev.books;

import com.dev.books.lib.Injector;
import com.dev.books.model.Author;
import com.dev.books.model.Book;
import com.dev.books.model.Genre;
import com.dev.books.service.AuthorService;
import com.dev.books.service.BookService;
import com.dev.books.service.GenreService;
import java.util.List;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.dev.books");
    private static AuthorService authorService =
            (AuthorService) INJECTOR.getInstance(AuthorService.class);
    private static BookService bookService =
            (BookService) INJECTOR.getInstance(BookService.class);
    private static GenreService genreService =
            (GenreService) INJECTOR.getInstance(GenreService.class);

    public static void main(String[] args) {
        Genre novelGenre = new Genre();
        novelGenre.setName("novel");
        genreService.add(novelGenre);

        Genre fairyTaleGenre = new Genre();
        fairyTaleGenre.setName("fairly tale");
        genreService.add(fairyTaleGenre);

        Author michaelBulgakov = new Author();
        michaelBulgakov.setFirstName("Michael");
        michaelBulgakov.setLastName("Bulgakov");
        authorService.add(michaelBulgakov);

        Author joanneRowling = new Author();
        joanneRowling.setFirstName("Joanne");
        joanneRowling.setLastName("Rowling");
        authorService.add(joanneRowling);

        Author arkadyiStrohatskoi = new Author();
        arkadyiStrohatskoi.setFirstName("Arkadyi");
        arkadyiStrohatskoi.setLastName("Strohatskoi");
        authorService.add(arkadyiStrohatskoi);

        Author borysStrohatskoi = new Author();
        borysStrohatskoi.setFirstName("Arkadyi");
        borysStrohatskoi.setLastName("Strohatskoi");
        authorService.add(borysStrohatskoi);

        Book mondayStartOnSaturdayBook = new Book();
        mondayStartOnSaturdayBook.setTitle("Monday start on Saturday");
        mondayStartOnSaturdayBook.setGenre(fairyTaleGenre);
        mondayStartOnSaturdayBook.setAuthors(List.of(arkadyiStrohatskoi, borysStrohatskoi));
        bookService.add(mondayStartOnSaturdayBook);

        Book harryPotterBook = new Book();
        harryPotterBook.setTitle("Harry Potter");
        harryPotterBook.setGenre(fairyTaleGenre);
        harryPotterBook.setAuthors(List.of(joanneRowling));
        bookService.add(harryPotterBook);

        Book theMasterAndMargaritaBook = new Book();
        theMasterAndMargaritaBook.setTitle("The Master And Margarita");
        theMasterAndMargaritaBook.setGenre(novelGenre);
        theMasterAndMargaritaBook.setAuthors(List.of(michaelBulgakov));
        bookService.add(theMasterAndMargaritaBook);

        Book book = bookService.getBookByTitle("The Master And Margarita");
        System.out.println("\n\n\n");
        System.out.println(book.toString());
        System.out.println("Books by author:");
        bookService.getBooksByAuthor(arkadyiStrohatskoi).forEach(System.out::println);
        System.out.println("Books by genre:");
        bookService.getBooksByGender(fairyTaleGenre).forEach(System.out::println);
    }
}
