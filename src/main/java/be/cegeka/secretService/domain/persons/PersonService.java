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

    public void addUser(String firstName, String lastName){
        personRepo.addUser(new Person(counter.incrementAndGet(), firstName, lastName));
    }

    public List<Person> getAllUsers() {
        return personRepo.getAllUsers();
    }
}
