package be.cegeka.secretService.domain.persons;

public class Person {

    private final long id;
    private final String firstName;
    private final String lasrName;

    public Person(long id, String name, String firstName) {
        this.id = id;
        this.firstName = name;
        this.lasrName = firstName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasrName() {return lasrName;}

    public String getFullName() { return String.format("%s %s", lasrName, firstName);}

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
