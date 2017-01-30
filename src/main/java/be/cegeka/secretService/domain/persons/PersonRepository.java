package be.cegeka.secretService.domain.persons;

import be.cegeka.secretService.domain.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class PersonRepository extends BaseRepository<Person>{

    private static final String FILE = ".\\data\\personRepo.ser";

    @Autowired
    public PersonRepository(){
        super(FILE);
        readRepoFromFile();
    }

    public void addPerson(Person person) {
        data.add(person);
        writeRepoToFile();
    }

    public Person readPerson(String firstName, String lastName) {
        Optional<Person> result = data.stream()
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

        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
