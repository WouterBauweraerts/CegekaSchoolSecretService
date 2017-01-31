package be.cegeka.secretService.domain.sotd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roelg on 31/01/2017.
 */
public class SOTDRepository {

    List<SOTD> sotdList = new ArrayList<>();

    public SOTD getSecretOf(LocalDate day) {
        SOTD output = null;
        for (SOTD sotd : sotdList) {
            if (sotd.getDate().equals(day)){
                output = sotd;
            }
        }
        return output;
    }

    public void addSOTD(SOTD sotd) {
        sotdList.add(sotd);
    }
}
