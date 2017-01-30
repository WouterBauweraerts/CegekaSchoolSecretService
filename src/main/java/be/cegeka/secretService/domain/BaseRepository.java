package be.cegeka.secretService.domain;

import be.cegeka.secretService.infrastructure.DataManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wouterba on 26/01/2017.
 */
public abstract class BaseRepository <T> {
    private final String file;
    protected List<T> data = new ArrayList<T>();

    @Inject
    private DataManager mgr;


    public BaseRepository(String file){
        this.file = file;
    }

    public List<T> getAll(){
        return new ArrayList<T>(data);
    }

    public String getFile() {
        return file;
    }

    public void writeRepoToFile(){
        mgr.writeRepoToFile(this);
    }

    public void readRepoFromFile(){
        this.data =  mgr.readRepoFromFile(this);
    }
}
