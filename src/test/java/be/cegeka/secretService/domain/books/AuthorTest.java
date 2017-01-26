package be.cegeka.secretService.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

    private Author author;

    @Before
    public void setup() {
        author = new Author("Dan", "Brown");
    }

    @Test
    public void toString_returnsString() throws Exception {
        String expected = "Dan Brown";
        Assertions.assertThat(author.toString()).isEqualTo(expected);
    }

    @Test
    public void equals_returnsEqualObject() throws Exception {
        Author expected = new Author("Dan", "Brown");
        Assertions.assertThat(author).isEqualTo(expected);
        Assertions.assertThat(author).isEqualTo(author);
    }

    @Test
    public void equals_returnsNull() throws Exception {
        Assertions.assertThat(author.equals(null)).isFalse();
    }


}