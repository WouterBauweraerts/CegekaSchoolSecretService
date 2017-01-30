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
    private SecretRepository testedRepo = new SecretRepository();// = mock(SecretRepository.class) ;

    @Mock
    private DataManager dataManager;// = mock(DataManager.class);

    @Mock
    private Secret secretMock;

    @Test
    public void writeRepoToFile() throws Exception {

        //doNothing().when(((BaseRepository) testedRepo)).writeRepoToFile();

        // testedRepo.addSecret(new Secret(4L,"    ","  "));

        //verify(testedRepo).writeRepoToFile();

        System.out.println(testedRepo);
        testedRepo.addSecret(secretMock);
        verify(dataManager).writeRepoToFile(anyList());
    }

    @Test
    public void readRepoFromFile() throws Exception {

    }
}