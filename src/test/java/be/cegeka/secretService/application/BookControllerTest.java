package be.cegeka.secretService.application;

import be.cegeka.secretService.domain.books.Author;
import be.cegeka.secretService.domain.books.Book;
import be.cegeka.secretService.domain.books.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

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