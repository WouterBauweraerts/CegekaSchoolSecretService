package be.cegeka.secretService.domain.persons;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class PersonRepository implements Serializable {

    private final String file = ".\\data\\personRepo.ser";
    private List<Person> people = new ArrayList<>();

    @Autowired
    public PersonRepository(){
        readRepoFromFile();
    }

    public List<Person> getAllPerson() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
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
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(people);
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readRepoFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            this.people = (List<Person>) in.readObject();
        } catch (FileNotFoundException fe) {
            this.people = new ArrayList<>(); //file doesn't exist
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
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
