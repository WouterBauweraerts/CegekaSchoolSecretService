package be.cegeka.secretService.domain.secrets;

import be.cegeka.secretService.domain.persons.Person;

/**
 * Created by roelg on 26/01/2017.
 */
public class Secret {
    Person owner;
    String secret;

    public Secret(Person owner, String secret) {
        this.owner = owner;
        this.secret = secret;
    }

    public Person getOwner() {
        return owner;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Secret secret1 = (Secret) o;

        if (owner != null ? !owner.equals(secret1.owner) : secret1.owner != null) return false;
        return secret != null ? secret.equals(secret1.secret) : secret1.secret == null;
    }

    @Override
    public int hashCode() {
        int result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        return result;
    }
}
