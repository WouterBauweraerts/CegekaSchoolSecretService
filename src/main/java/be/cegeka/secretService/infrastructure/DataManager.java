package be.cegeka.secretService.infrastructure;

import be.cegeka.secretService.domain.persons.Person;

import javax.inject.Named;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wouterba on 26/01/2017.
 */
public class DataManager {

    private String file;

    public DataManager(String file) {
        this.file = file;
    }

    public void writeRepoToFile(List list){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(list);
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList readRepoFromFile (){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return new ArrayList<>((List) (in.readObject()));
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
