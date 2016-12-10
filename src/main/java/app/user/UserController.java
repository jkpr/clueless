package app.user;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Application.userManager;
import static app.util.RequestUtil.GREEN_MSG;
import static app.util.RequestUtil.getQueryEmail;

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

    public static Route serveForgotpasswordPage = (Request request, Response response) -> {
        return ViewUtil.render(null, Path.Template.FORGOTPASSWORD);
    };

    public static Route handleForgotpasswordPost = (Request request, Response response) -> {
        Map<String, Object> map = new HashMap<>();
        String email = getQueryEmail(request);
        if (email != null) {
            map.put(GREEN_MSG, String.format("An email has been sent to %s", email));
        }
        return ViewUtil.render(map, Path.Template.FORGOTPASSWORD);
    };
}
