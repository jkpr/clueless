package app.index;

import app.util.Path;
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
        String[] members = {"Christopher Chang", "Federico Esparza", "James Pringle", "Ibrahim Salla"};
        map.put("members", members);
        map.put("footer", Path.Template.FOOTER);
        return ViewUtil.render(map, Path.Template.INDEX);
    };
}
