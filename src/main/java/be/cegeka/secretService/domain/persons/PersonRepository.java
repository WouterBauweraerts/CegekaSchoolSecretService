package be.cegeka.secretService.domain.persons;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class PersonRepository {

    private List<Person> people = new ArrayList<>();

    public List<Person> getAllUsers() {
        return people;
    }

    public void addUser(Person person){
        people.add(person);
    }
}
