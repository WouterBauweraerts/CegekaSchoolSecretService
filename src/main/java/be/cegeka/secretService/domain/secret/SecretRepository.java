package be.cegeka.secretService.domain.secret;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roelg on 26/01/2017.
 */
@Named
public class SecretRepository {
    List<Secret> secrets = new ArrayList<>();

    public List<Secret> getAllSecrets() {
        return secrets;
    }

    public void addSecret(Secret secret){
        secrets.add(secret);
    }

    public void removeSecret(Secret secret){
        secrets.remove(secret);
    }

}
