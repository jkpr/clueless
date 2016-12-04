package app.user;

import static app.Application.userManager;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by james on 12/1/16.
 */
public class UserController {
    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        User user = userManager.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        return password.equals(user.getPassword());
    }

    // This method doesn't do anything, it's just included as an example
    public static void setPassword(String username, String oldPassword, String newPassword) {
        if (authenticate(username, oldPassword)) {
            //String newSalt = BCrypt.gensalt();
            //String newHashedPassword = BCrypt.hashpw(newSalt, newPassword);
            // Update the user salt and password
        }
    }

    public static Route serveUserPage = (Request request, Response response) -> {

        return ViewUtil.render(null, Path.Template.USER);

    };
}
