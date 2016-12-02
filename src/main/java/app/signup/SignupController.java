package app.signup;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by Ibrahim on 12/2/2016.
 */
public class SignupController {
    public static Route serveSignupPage = (Request request, Response response) -> {

        return ViewUtil.render(null, Path.Template.SIGNUP);

    };

}