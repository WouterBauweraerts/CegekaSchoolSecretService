package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.persons.Person;
import be.cegeka.secretService.domain.persons.PersonService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by roelg on 26/01/2017.
 */
@Named
public class SecretService {

    private final AtomicLong counter = new AtomicLong();
    private static Secret secretOfTheDay;


    @Inject
    SecretRepository secretRepository;
    @Inject
    PersonService personService;
    
    public void addSecret(String secretString, String firstName, String lastName){
        Person owner = personService.getPerson(firstName,lastName);
        if (owner == null){
            owner = personService.addPerson(firstName,lastName);
        }
        secretRepository.addSecret(new Secret(counter.incrementAndGet(), secretString,owner.getEncryptedHash()));
    }

    public Secret getRandomSecret() {
        return secretRepository.getRandomSecret();
    }

    public List<Person> getPersonsWithoutSecret() {
        List<Person> personsWithoutSecret = new ArrayList<>();
        for (Person person : personService.getAllPersons()) {
            if (!personHasSecret(person.getEncryptedHash())) {
                personsWithoutSecret.add(person);
            }
        }
        return personsWithoutSecret;
    }

    private boolean personHasSecret(String encryptedHash) {
        boolean hasSecret = false;
        for (Secret secret : secretRepository.getAll()) {
            if (encryptedHash.equals(secret.getOwnerHash())) {
                hasSecret = true;
            }
        }
        return hasSecret;
    }
}
