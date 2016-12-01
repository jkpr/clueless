package app.login;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 11/30/16.
 */
public class LoginController {
    public static Route serveLoginPage = (Request request, Response response) -> {
        return ViewUtil.render(null, Path.Template.LOGIN);
    };
}
