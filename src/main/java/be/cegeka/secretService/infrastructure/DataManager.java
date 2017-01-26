package be.cegeka.secretService.infrastructure;

import be.cegeka.secretService.domain.BaseRepository;

import javax.inject.Named;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by wouterba on 26/01/2017.
 */
@Named
public class DataManager {

    public void writeRepositoryToFile(BaseRepository repo){
        String file = repo.getFile();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(repo.readAll());
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
