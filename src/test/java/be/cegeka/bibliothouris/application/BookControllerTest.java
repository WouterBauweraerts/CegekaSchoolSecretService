package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Author;
import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.books.BookService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

public class BookControllerTest {

    private Book book;
    private BookService bookService;
    private BookController controller;

    @Before
    public void setup(){
        Author author = new Author("J.K.", "Rowling");
        book = new Book("12345", "Harry Potter", author);
        bookService = new BookService();
        bookService.addBook("12345", "Harry Potter", "J.K.", "Rowling");
        controller = new BookController();
        controller.addBook("The Da Vinci Code", "123456", "Dan", "Brown");
    }

    @Test
    public void getBookDetails_returnsBookDetails(){
        String expected = "Harry Potter (12345)";
        Assertions.assertThat(expected).isEqualTo(book.getShortDetails());
    }

    @Test
    public void searchBook_returnsPartialIsbn(){
        Assertions.assertThat(bookService.searchBook("123*").size()).isEqualTo(1);
    }

    @Test
    public void searchBookByPartialIsbn_ResultFound_ReturnsHttpStatusOk(){
        Assertions.assertThat(controller.searchBook("12*").getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void searchBookByPartialIsbn_NoResultFound_ReturnsHttpStatusNoContent(){
        Assertions.assertThat(controller.searchBook("612*").getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

}