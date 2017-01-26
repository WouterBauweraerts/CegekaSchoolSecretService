package be.cegeka.secretService.domain.persons;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wouterba on 26/01/2017.
 */
public class PersonRepositoryTest {
    private static PersonRepository repo;

    @BeforeClass
    public static void setUp(){
        repo = new PersonRepository();
        repo.addPerson(new Person(1, "Wouter", "Bauweraerts"));
        repo.addPerson(new Person(2, "Roel", "Goossens"));
        repo.addPerson(new Person(3, "Seppe", "Gielen"));
    }

    @Test
    public void deserializedRepoContainsExactlyTheSameAsTheRepoBeforeSerialization(){
        repo.writePersonRepoToFile();
        PersonRepository deserialized = new PersonRepository();

        Assertions.assertThat(repo).isEqualTo(deserialized);
    }

    @Test
    public void deserializedRepoWithExtraPersonNotContainsExactlyTheSameAsTheRepoBeforeSerialization(){
        repo.writePersonRepoToFile();
        repo.addPerson(new Person(4,"Sanne", "Vermeiren"));
        PersonRepository deserialized = new PersonRepository();

        Assertions.assertThat(repo).isNotEqualTo(deserialized);
    }
}