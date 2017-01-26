package be.cegeka.secretService.domain;

import java.util.List;

/**
 * Created by wouterba on 26/01/2017.
 */
public abstract class BaseRepository <T> {
    private final String file;

    public BaseRepository(String file){
        this.file = file;
    }
    public abstract List<T> readAll();

    public String getFile() {
        return file;
    }


}
