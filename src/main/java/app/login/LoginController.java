package app.login;

import app.user.UserController;
import app.util.Path;
import app.util.RequestUtil;
import app.util.ViewUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.util.RequestUtil.*;


/**
 * Created by james on 11/30/16.
 */
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public static Route serveLoginPage = (Request request, Response response) -> {
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        if (username != null) {
            response.redirect(Path.Web.USER);
            return null;
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("login", true);
            String greenMsg = request.session().attribute(GREEN_MSG);
            if (greenMsg != null) {
                map.put(GREEN_MSG, greenMsg);
                request.session().removeAttribute(GREEN_MSG);
            }
            return ViewUtil.render(map, Path.Template.LOGIN);
        }
    };

    public static Route handleLoginPost = (Request request, Response response) -> {
        String username = getQueryUsername(request);
        String password = getQueryPassword(request);
        boolean authenticated = UserController.authenticate(username, password);
        if (authenticated) {
            logger.info("Authenticated {}", username);
            request.session().attribute(CURRENT_USER, username);
            if (getQueryLoginRedirect(request) != null) {
                response.redirect(getQueryLoginRedirect(request));
            } else {
                response.redirect(Path.Web.GAME);
            }
            return null;
        } else {
            logger.info("Failed to authenticate {}", username);
            Map<String, Object> map = new HashMap<>();
            map.put(RED_MSG, "Incorrect username or password");
            map.put("login", true);
            return ViewUtil.render(map, Path.Template.LOGIN);
        }
    };

    public static Route handleLogout = (Request request, Response response) -> {
        request.session().removeAttribute(CURRENT_USER);
        request.session().attribute(GREEN_MSG, "Logged out successfully");
        response.redirect(Path.Web.LOGIN);
        return null;
    };
}
