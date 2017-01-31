package be.cegeka.secretService.domain.persons;

import be.cegeka.secretService.domain.secrets.Secret;
import be.cegeka.secretService.infrastructure.DataManager;

import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class PersonRepository {

    private DataManager mgr = new DataManager(".\\data\\personRepo.ser");
    private List<Person> people = mgr.readRepoFromFile();

    public List<Person> getAll() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
        mgr.writeRepoToFile(people);
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
