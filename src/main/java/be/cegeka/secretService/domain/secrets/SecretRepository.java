package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.BaseRepository;
import be.cegeka.secretService.infrastructure.DataManager;

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

    private static final String file = ".\\data\\secretRepo.ser";

    List<Secret> secrets = new ArrayList<>();

    @Inject
    private DataManager mgr;

    public SecretRepository() {
        super(file);
    }

    public List<Secret> readAll() {
        return secrets;
    }

    public void addSecret(Secret secret){
        secrets.add(secret);
    }

    public void removeSecret(Secret secret){
        secrets.remove(secret);
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
