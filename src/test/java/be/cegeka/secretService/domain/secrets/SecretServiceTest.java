package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.persons.Person;
import be.cegeka.secretService.domain.persons.PersonService;
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

/**
 * Created by roelg on 26/01/2017.
 */
public class SecretServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks //tested object
    private SecretService testedService;

    @Mock
    private PersonService personService;

    @Mock
    private SecretRepository secretRepository;


    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(testedService, "counter", new AtomicLong(4l));
    }

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {

        Person testPerson = new Person(4L, "Seppe", "Gielen");
        String hash = testPerson.getEncryptedHash();

        when(personService.addPerson("Seppe", "Gielen")).thenReturn(testPerson);

        testedService.addSecret("I skinned a unicorn yesterday", "Seppe", "Gielen");

        verify(secretRepository).addSecret(new Secret(5l, "I skinned a unicorn yesterday", hash));
    }

    @Test
    public void getRandomSecretShouldReturnASecret() throws Exception {
        Secret secret1 = new Secret(1l, "Seppe", "Gielen");
        Secret secret2 = new Secret(2l, "Sanne", "Gielen");
        Secret secret3 = new Secret(3l, "Xan", "Gielen");

        when(secretRepository.readAll()).thenReturn(Arrays.asList(secret1, secret3));
        when(secretRepository.getRandomSecret()).thenReturn(secret2);

        Secret testResult = testedService.getRandomSecret();
        assertThat(testResult).isIn(secret1, secret2, secret3);
    }
}