package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.BaseRepository;

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


}
