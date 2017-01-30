package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.BaseRepository;
import be.cegeka.secretService.infrastructure.DataManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by roelg on 26/01/2017.
 */
@Named
public class SecretRepository extends BaseRepository<Secret> {

    private static final String FILE = ".\\data\\secretRepo.ser";

    @Autowired
    public SecretRepository() {
        super(FILE);
        readRepoFromFile();
    }

    public List<Secret> getAll() {
        return data;
    }

    public void addSecret(Secret secret){
        data.add(secret);
        writeRepoToFile();
    }

    public void removeSecret(Secret secret){
        data.remove(secret);
        writeRepoToFile();
    }

    public Secret getRandomSecret() {
        return  data.get(new Random().nextInt(data.size()));
    }


}
