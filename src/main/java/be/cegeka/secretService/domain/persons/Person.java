package be.cegeka.secretService.domain.persons;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Person implements Serializable{

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
            return new String(Files.readAllBytes(Paths.get(".\\data\\secret\\secretKey.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {return lastName;}

    public String getFullName() { return String.format("%s %s", lastName, firstName);}

    public String getEncryptedHash(){
        String secret = readKey();
        String nameToHash = getFullName();
        String hashed = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((nameToHash+secret).getBytes());
            hashed = new BigInteger(md.digest()).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashed;
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

        if (!firstName.equals(person.firstName)) return false;
        return lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
