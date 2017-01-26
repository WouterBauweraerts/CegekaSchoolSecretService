package be.cegeka.secretService.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xanv on 25/01/2017.
 */
public class BookRepositoryTest {
    private BookRepository br;
    @Before
    public void setUp(){
        br = new BookRepository();
        br.addBook(new Book("123456", "The Da Vinci Code", new Author("Dan", "Brown")));
        br.addBook(new Book("123", "Harry Potter", new Author ("J.K.", "Rowling")));
        br.addBook(new Book("2345", "Perfume", new Author("Patrick", "Suskind")));
        br.addBook(new Book("87949","The Horse Whisperer", new Author("Jos", "Vanopdenhoek")));
    }

    @Test
    public void getDetailsBook(){

        br.getShortDetails("123");

        String expected = "Harry Potter (123)";
        Assertions.assertThat(br.getShortDetails("123")).isEqualTo(expected);
    }

    @Test
    public void searchBookWithWildcards_ShouldReturnOneBook(){
        String wildCard = "123*6";

        Assertions.assertThat(br.searchBookISBN(wildCard).size()).isEqualTo(1);
    }

    @Test
    public void searchBookWithWildcard_ShouldReturn2(){
        String wildcard = "12*";

        Assertions.assertThat(br.searchBookISBN(wildcard).size()).isEqualTo(2);
    }
    @Test
    public void searchBookWithWildcardTitlePer_ShouldReturn1(){
        String wildcard ="Per*";
        Assertions.assertThat(br.searchBookPartialTitle(wildcard).size()).isEqualTo(1);
    }
    @Test
    public void searchBookWithWildcardTitleThe_ShouldReturn2(){
        String wildcard ="The*";
        Assertions.assertThat(br.searchBookPartialTitle(wildcard).size()).isEqualTo(2);
    }

    // TEST BELOW IS INVALID -- NEEDS A FIX!!!
    @Test
    public void searchBookWithWildcardTitleThe_ShouldReturn1(){
        String wildcard ="The Da*";
        Assertions.assertThat(br.searchBookPartialTitle(wildcard).size()).isEqualTo(1);
    }


}
