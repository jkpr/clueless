package app.user;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

/**

 * Created by Ibrahim on 12/3/16.

 */

public class UserController {

    public static Route serveUserPage = (Request request, Response response) -> {

        return ViewUtil.render(null, Path.Template.USER);

    };

}