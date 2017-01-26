package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wouterba on 25/01/2017.
 */
public class AuthorRepositoryTest {
    private AuthorRepository repo;

    @Before
    public void setUp(){
        repo = new AuthorRepository();
        repo.addAuthor("Dan", "Brown");
        repo.addAuthor("Pieter", "Aspe");
    }

    @Test
    public void addAuthor_AddsAuthorToRepo_sizeShouldBe(){
        Assertions.assertThat(repo.getAllAuthors().size()).isEqualTo(2);
    }

    @Test
    public void addAuthor_AddsAuthor_returnsCreatedAuthor(){
        Author expected = new Author("JK","Rowling");
        Assertions.assertThat(repo.addAuthor("JK", "Rowling")).isEqualTo(expected);
    }

    @Test
    public void getAuthor_returnedAuthorIsEqualToAuthorWithSameNameAndFirstName(){
        Assertions.assertThat(repo.getAuthor("Dan", "Brown")).isEqualTo(new Author("Dan", "Brown"));
    }
}