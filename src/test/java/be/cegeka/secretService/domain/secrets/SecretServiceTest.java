package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.persons.PersonRepository;
import be.cegeka.secretService.domain.persons.PersonService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by roelg on 26/01/2017.
 */
public class SecretServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SecretService secretService;

    @Mock
    private SecretRepository secretRepository;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(secretService, "counter", new AtomicLong(4l));
    }

    @Test
    public void add_Secret_Should_() throws Exception {

    }
}