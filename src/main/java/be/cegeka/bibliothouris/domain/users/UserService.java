package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;

    private final AtomicLong counter = new AtomicLong();

    public void addUser(String name){
        userRepository.addUser(new User(counter.incrementAndGet() , name));
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
