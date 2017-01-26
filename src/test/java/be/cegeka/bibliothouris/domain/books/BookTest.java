package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xanv on 25/01/2017.
 */
public class BookTest {
    private Book book;
    private Author author;

    @Before
    public void setUp() {
        author = new Author("J.K.", "Rowling");
        book = new Book("12345", "Harry Potter", author);
    }

    @Test
    public void ShouldReturnISBNTitleAndAuthor(){
        String expected = "isbn: 12345, title: Harry Potter, author: J.K. Rowling.";
        Assertions.assertThat(expected).isEqualTo(book.toString());
    }

    @Test
    public void getDetails_returnsDetails(){
        String expected = "Harry Potter (12345)";
        Assertions.assertThat(expected).isEqualTo(book.getShortDetails());
    }

}