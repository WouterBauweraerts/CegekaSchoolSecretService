package be.cegeka.secretService.domain.secrets;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Random;

/**
 * Created by roelg on 26/01/2017.
 */
@Named
public class SecretService {

    @Inject
    SecretRepository secretRepository;

    public Secret getRandomSecret() {
        List<Secret> secretList = secretRepository.getAllSecrets();
        Secret output  = secretList.get(new Random().nextInt(secretList.size()));
        secretRepository.removeSecret(output);
        return output;
    }

}
