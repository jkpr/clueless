package app.gameplay;

import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by federico on 12/05/16.
 */

public class GamePlayController {

    public static Route serveGamePlayPage = (Request request, Response response) -> {
        return ViewUtil.render(null, Path.Template.GAME_PLAY);
    };
}