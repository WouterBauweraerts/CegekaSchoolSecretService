package be.cegeka.secretService.domain.persons;

import be.cegeka.secretService.infrastructure.DataManager;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

/**
 * Created by roelg on 30/01/2017.
 */
public class PersonRepositoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private PersonRepository testedRepo;

    @Mock
    private DataManager dataManager;

    @Mock
    private Person secretMock;

    @Test
    public void writeRepoToFile() throws Exception {
        testedRepo.addPerson(secretMock);
        verify(dataManager).writeRepoToFile(anyList());
    }

}