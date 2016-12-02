package app.login;

import app.user.UserController;
import app.util.Path;
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
        return ViewUtil.render(null, Path.Template.LOGIN);
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
                response.redirect(Path.Web.GAME_LOBBY);
            }
            return null;
        } else {
            logger.info("Failed to authenticate {}", username);
            Map<String, Object> map = new HashMap<>();
            return ViewUtil.render(map, Path.Template.LOGIN);
        }
    };
}
