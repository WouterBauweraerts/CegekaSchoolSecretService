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
    private PersonService userService;

    @Mock
    private PersonRepository userRepository;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(userService, "counter", new AtomicLong(4l));
    }

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        userService.addUser("Seppe");

        verify(userRepository).addUser(new Person(5l, "Seppe"));
    }

    @Test
    public void getAllUsers() throws Exception {
        Person person1 = new Person(1l, "Seppe");
        Person person2 = new Person(2l, "Sanne");
        Person person3 = new Person(3l, "Xan");

        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(person1, person2));

        assertThat(userService.getAllUsers()).containsOnly(person1, person2);
    }
}