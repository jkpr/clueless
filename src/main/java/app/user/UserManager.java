package app.user;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by james on 12/1/16.
 */
public class UserManager {
    public final List<User> users = new LinkedList<>();

    public UserManager() {
        users.add(new User("chris", "chris"));
        users.add(new User("james", "james"));
        users.add(new User("federico", "federico"));
        users.add(new User("Ibrahim", "Ibrahim"));
    }

    public User getUserByUsername(String username) {
        return users.stream().filter(b -> b.getUsername().equals(username)).findFirst().orElse(null);
    }
}
