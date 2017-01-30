package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.infrastructure.DataManager;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.verify;

/**
 * Created by roelg on 30/01/2017.
 */
public class SecretRepositoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SecretRepository testedRepo;

    @Mock
    private DataManager dataManager;

    @Mock
    private Secret secretMock;

    @Test
    public void writeRepoToFile() throws Exception {
        testedRepo.addSecret(secretMock);
        verify(dataManager).writeRepoToFile(anyList());
    }
}