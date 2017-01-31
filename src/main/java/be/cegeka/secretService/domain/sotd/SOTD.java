package be.cegeka.secretService.domain.sotd;

import be.cegeka.secretService.domain.secrets.Secret;

import java.time.LocalDate;

/**
 * Created by roelg on 31/01/2017.
 */
public class SOTD {
    private LocalDate date;
    private Secret secret;

    public SOTD( Secret secret,LocalDate date) {
        this.date = date;
        this.secret = secret;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSecretString() {
        return secret.getSecret();
    }
}
