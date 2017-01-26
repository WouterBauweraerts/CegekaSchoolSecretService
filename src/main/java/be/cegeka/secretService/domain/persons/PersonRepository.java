package be.cegeka.secretService.domain.persons;

import be.cegeka.secretService.domain.BaseRepository;
import be.cegeka.secretService.infrastructure.DataManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class PersonRepository extends BaseRepository<Person>{

    private static final String file = ".\\data\\personRepo.ser";
    private List<Person> people = new ArrayList<>();

    @Inject
    private DataManager mgr;

    @Autowired
    public PersonRepository(){
        super(file);
        readRepoFromFile();
    }

    @Override
    public List<Person> readAll() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
        writePersonRepoToFile();
    }

    public Person readPerson(String firstName, String lastName) {
        Optional<Person> result = people.stream()
                .filter(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName))
                .findFirst();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    public void writePersonRepoToFile() {
        mgr.writeRepositoryToFile(this);
    }

    public void readRepoFromFile() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonRepository that = (PersonRepository) o;

        return people.equals(that.people);
    }

    @Override
    public int hashCode() {
        return people.hashCode();
    }
}
