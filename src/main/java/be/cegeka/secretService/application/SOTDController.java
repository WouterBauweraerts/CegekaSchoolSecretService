package be.cegeka.secretService.application;

import be.cegeka.secretService.domain.sotd.SOTDService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by roelg on 31/01/2017.
 */
@Controller
@RequestMapping(value = "/sotd")
public class SOTDController {

    @Inject
    private SOTDService sotdService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getSecretOfTheDay(){
        return  sotdService.getSecretOfTheDay();
    }
}
