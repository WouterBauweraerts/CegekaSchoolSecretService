/*
Disabled since it has no functional use

package be.cegeka.secretService.application;

import be.cegeka.secretService.domain.persons.Person;
import be.cegeka.secretService.domain.persons.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Inject
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Person> getPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addUser(@RequestParam(value = "last name", required = true) String firstName,
                 @RequestParam(value = "first name", required = true) String lastName) {
        personService.addPerson(firstName,lastName);
    }

}
*/
