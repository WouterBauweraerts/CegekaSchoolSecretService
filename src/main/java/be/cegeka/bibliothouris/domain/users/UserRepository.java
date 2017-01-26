package be.cegeka.bibliothouris.domain.users;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }
}
