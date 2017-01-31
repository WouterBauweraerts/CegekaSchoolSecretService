package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.infrastructure.DataManager;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by roelg on 26/01/2017.
 */
@Named
public class SecretRepository {

    private DataManager mgr = new DataManager( ".\\data\\secretRepo.ser");
    private List<Secret> secrets = mgr.readRepoFromFile();

    public List<Secret> getAll() {
        return secrets;
    }

    public void addSecret(Secret secret){
        secrets.add(secret);
        mgr.writeRepoToFile(secrets);
    }

    public void removeSecret(Secret secret){
        secrets.remove(secret);
        mgr.readRepoFromFile();
    }

    public Secret getRandomSecret() {
        return  secrets.get(new Random().nextInt(secrets.size()));
    }


}
