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

    List<Secret> secrets = new ArrayList<>();

    @Inject
    private DataManager mgr;

    @Autowired
    public SecretRepository() {
        super(FILE);
        mgr = new DataManager();
        readRepoFromFile();
    }

    public List<Secret> readAll() {
        return secrets;
    }

    public void addSecret(Secret secret){
        secrets.add(secret);
        writeSecretRepoToFile();
    }

    public void removeSecret(Secret secret){
        secrets.remove(secret);
        writeSecretRepoToFile();
    }

    public Secret getRandomSecret() {
        return  secrets.get(new Random().nextInt(secrets.size()));
    }

    public void writeSecretRepoToFile(){
        mgr.writeRepositoryToFile(this);
    }

    public void readRepoFromFile(){
       this.secrets =  mgr.readRepoFromFile(this);
    }
}
