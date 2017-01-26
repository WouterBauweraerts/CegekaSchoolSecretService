package be.cegeka.secretService.domain.persons;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class PersonService {

    @Inject
    private PersonRepository personRepo;

    private final AtomicLong counter = new AtomicLong();

    public Person addPerson(String firstName, String lastName){
        Person personToAdd = new Person(counter.incrementAndGet(), firstName, lastName);
        personRepo.addPerson(personToAdd);
        return personToAdd;
    }

    public List<Person> getAllPersons() {
        return personRepo.getAllPerson();
    }

    public Person getPerson(String firstName, String lastName){
        return personRepo.readPerson(firstName, lastName);
    }
}
