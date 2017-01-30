package be.cegeka.secretService.infrastructure;

import be.cegeka.secretService.domain.BaseRepository;
import be.cegeka.secretService.domain.persons.Person;

import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wouterba on 26/01/2017.
 */
@Named
public class DataManager {

    public void writeRepositoryToFile(BaseRepository repo){
        String file = repo.getFile();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(repo.getAll());
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List readRepoFromFile(BaseRepository repo){
        String file = repo.getFile();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Person>) in.readObject();
        } catch (FileNotFoundException fe) {
            return new ArrayList<>(); //file doesn't exist
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
            return new ArrayList<>(); //file doesn't exist
        } catch (IOException io) {
            io.printStackTrace();
            return new ArrayList<>(); //file doesn't exist
        }
    }
}
