package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.persons.Person;
import be.cegeka.secretService.domain.persons.PersonService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by roelg on 26/01/2017.
 */
@Named
public class SecretService {

    @Inject
    SecretRepository secretRepository;
    @Inject
    PersonService personService;

    private final AtomicLong counter = new AtomicLong();


    public void addSecret(String secretString, String firstName, String lastName){
        Person owner = personService.getPerson(firstName,lastName);
        if (owner == null){
            owner = personService.addPerson(firstName,lastName);
        }
        secretRepository.addSecret(new Secret(counter.incrementAndGet(), secretString,owner.getEncryptedHash()));
    }

    public Secret getRandomSecret() {
        Secret output = secretRepository.getRandomSecret();
        secretRepository.removeSecret(output);
        return output;
    }

}
