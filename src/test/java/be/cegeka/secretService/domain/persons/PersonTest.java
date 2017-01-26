package be.cegeka.secretService.domain.persons;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wouterba on 26/01/2017.
 */
public class PersonTest {
    private Person person;

    @Before
    public void setUp(){
        person = new Person(1, "Wouter", "Bauweraerts");
    }

    @After
    public void tearDown(){
        person = null;
    }

    @Test
    public void personGetFirstName_ShouldReturnWouter(){
        Assertions.assertThat(person.getFirstName()).isEqualTo("Wouter");
    }

    @Test
    public void personGetLastName_ShouldReturnBauweraerts(){
        Assertions.assertThat(person.getLastName()).isEqualTo("Bauweraerts");
    }

    @Test
    public void personGetFullName_ShouldReturnWouter_Bauweraerts(){
        Assertions.assertThat(person.getFullName()).isEqualTo("Bauweraerts Wouter");
    }

    @Test
    public void personMultipleHashingsReturnEqualResults(){
        Assertions.assertThat(person.getEncryptedHash()).isEqualTo(person.getEncryptedHash());
        System.out.println(person.getEncryptedHash());
    }

}