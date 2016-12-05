package app.forgotpassword;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ibrahim on 12/1/2016.
 */
public class ForgotpasswordController {

    public static Route serveForgotpasswordPage = (Request request, Response response) -> {

        return ViewUtil.render(null, Path.Template.FORGOTPASSWORD);

    };

}