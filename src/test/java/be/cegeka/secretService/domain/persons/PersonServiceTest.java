package be.cegeka.secretService.domain.persons;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(personService, "counter", new AtomicLong(4l));
    }

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        personService.addPerson("Seppe","Gielen");

        verify(personRepository).addPerson(new Person(5l, "Seppe","Gielen"));
    }

    @Test
    public void getAllUsers() throws Exception {
        Person person1 = new Person(1l, "Seppe","Gielen");
        Person person2 = new Person(2l, "Sanne","Gielen");
        Person person3 = new Person(3l, "Xan","Gielen");

        when(personRepository.readAll()).thenReturn(Arrays.asList(person1, person2));

        assertThat(personService.getAllPersons()).containsOnly(person1, person2);
    }
}