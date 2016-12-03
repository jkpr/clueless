package app.game;

import app.util.Path;
import app.util.RequestUtil;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 11/26/16.
 */
public class GameController {
    public static Route serveGameLobby = (Request request, Response response) -> {
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        Map<String, Object> map = new HashMap<>();
        map.put("user", username);
        return ViewUtil.render(map, Path.Template.GAME);
    };
}
