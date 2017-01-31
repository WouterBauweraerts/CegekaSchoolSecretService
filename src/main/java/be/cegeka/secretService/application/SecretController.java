package be.cegeka.secretService.application;

import be.cegeka.secretService.domain.persons.Person;
import be.cegeka.secretService.domain.secrets.SecretService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by wouterba on 26/01/2017.
 */
@Controller
@RequestMapping(value = "/secret")
public class SecretController {

    @Inject
    private SecretService secretService;

    @RequestMapping(method = RequestMethod.POST)
    public String addSecret(
            @RequestParam(value = "secret") String secret,
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName){
        secretService.addSecret(secret, firstName, lastName);
        return "index.html";
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<Person>> getPersonsWithoutSecret(){
        List<Person> personsNoSecret = secretService.getPersonsWithoutSecret();

        if (personsNoSecret.size()==0){
            return new ResponseEntity<>(personsNoSecret, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personsNoSecret, HttpStatus.OK);
    }
}
