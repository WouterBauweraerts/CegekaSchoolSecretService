package be.cegeka.secretService.domain.persons;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Person {

    private final long id;
    private final String firstName;
    private final String lastName;

    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {return lastName;}

    public String getFullName() { return String.format("%s %s", lastName, firstName);}

    public String hashPerson(){
        String secret = readKey();
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
        return firstName != null ? firstName.equals(person.firstName) : person.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}