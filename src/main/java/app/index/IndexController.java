package app.index;

import app.util.Path;
import app.util.RequestUtil;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 11/25/16.
 */
public class IndexController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> map = new HashMap<>();
        if (request.session().attribute(RequestUtil.CURRENT_USER) != null) {
            map.put(RequestUtil.CURRENT_USER, request.session().attribute(RequestUtil.CURRENT_USER));
        }
        return ViewUtil.render(map, Path.Template.INDEX);
    };
}
