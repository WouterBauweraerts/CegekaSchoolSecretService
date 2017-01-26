package be.cegeka.secretService.domain.secret;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by roelg on 26/01/2017.
 */
@Named
public class SecretService {

    @Inject
    SecretRepository secretRepository;

}
