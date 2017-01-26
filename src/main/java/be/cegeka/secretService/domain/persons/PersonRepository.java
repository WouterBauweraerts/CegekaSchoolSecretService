package be.cegeka.secretService.domain.persons;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class PersonRepository implements Serializable{

    private List<Person> people = new ArrayList<>();

    public List<Person> getAllPerson() {
        return people;
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public Person readPerson(String firstName, String lastName){
        Optional<Person> result = people.stream()
                .filter(p-> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName))
                .findFirst();
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }
}
