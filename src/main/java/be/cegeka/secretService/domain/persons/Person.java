package be.cegeka.secretService.domain.persons;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Person {

    private final long id;
    private final String name;
    private final String firstName;
    private final String secretKey;

    public Person(long id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.secretKey = readKey();
    }

    private String readKey() {
        try {
            return new String(Files.readAllBytes(Paths.get("\\secret\\secretKey.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {return firstName;}

    public String getFullName() { return String.format("%s %s", firstName, name);}

    public String hashPerson(){

    }

    @Override
    public String toString() {
        return "Person: (" + id + ") " + getFullName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
