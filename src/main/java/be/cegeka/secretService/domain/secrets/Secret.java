package be.cegeka.secretService.domain.secrets;

/**
 * Created by roelg on 26/01/2017.
 */
public class Secret {
    long id;
    String secret;
    String ownerHash;

    public Secret(long id, String secret, String ownerHash) {
        this.id = id;
        this.secret = secret;
        this.ownerHash = ownerHash;
    }

    public long getId() {
        return id;
    }

    public String getOwnerHash() {
        return ownerHash;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Secret secret1 = (Secret) o;

        if (id != secret1.id) return false;
        if (secret != null ? !secret.equals(secret1.secret) : secret1.secret != null) return false;
        return ownerHash != null ? ownerHash.equals(secret1.ownerHash) : secret1.ownerHash == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        result = 31 * result + (ownerHash != null ? ownerHash.hashCode() : 0);
        return result;
    }

}
