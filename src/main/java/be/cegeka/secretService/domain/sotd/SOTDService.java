package be.cegeka.secretService.domain.sotd;

import be.cegeka.secretService.domain.secrets.Secret;
import be.cegeka.secretService.domain.secrets.SecretService;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;

/**
 * Created by roelg on 31/01/2017.
 */
@Named
public class SOTDService {

    @Inject
    SOTDRepository sotdRepository;

    @Inject
    SecretService secretService;

    public String getSecretOfTheDay() {  //Ugly, don't look at me unless you wanna fix me up
        SOTD sotd = sotdRepository.getSecretOf(LocalDate.now());
        if (sotd == null) {
            Secret randomSecret = secretService.getRandomSecret();
            sotdRepository.addSOTD(new SOTD(randomSecret, LocalDate.now()));
            if (sotdRepository.getSecretOf(LocalDate.now()) != null) {
                secretService.removeSecret(randomSecret);
            }
        }
        return sotd.getSecretString();
    }
}
