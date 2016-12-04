package app.game;

import app.game.model.Player;
import app.json.*;
import app.message.Messaging;
import app.util.Path;
import app.util.RequestUtil;
import app.util.ViewUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Application.game;
import static app.Application.jsonMapper;

/**
 * Created by james on 11/26/16.
 */
public class GameController {
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    // public static Route serveGameLobby ...

    public static Route serveGame = (Request request, Response response) -> {
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        if (username == null) {
            response.redirect(Path.Web.LOGIN);
            return null;
        } else {
            String sessionId = request.cookies().get(RequestUtil.SESSION_ID);
            logger.info("Serving game page to session id: {} and username: {}", sessionId, username);
            Messaging.usernameMap.put(sessionId, username);
            //for (Iterator<Chat> iter = Messaging.chatQueue.iterator(); iter.hasNext(); ) {
            //  Chat chat = iter.next();
            //if (chat.sessionId.equals(sessionId)) {
            //  iter.remove();
            //Messaging.broadcastJoinChat(username);
            // }
            //}
            Map<String, Object> map = new HashMap<>();
            map.put("user", username);
            return ViewUtil.render(map, Path.Template.GAME);
        }
    };

    public static Route handleAddPlayerPost = (Request request, Response response) -> {
        // Ignore API key for now. Only use session username.
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        if (username == null) {
            response.status(401);
            return null;
        } else {
            String json = request.body();
            AddPlayerPayload addPlayerPayload = jsonMapper.readValue(json, AddPlayerPayload.class);
            JsonResponse jsonResponse = game.handleAddPlayer(username, addPlayerPayload);
            response.status(jsonResponse.status);
            return new JSONObject().put("msg", jsonResponse.msg);
        }
    };

    public static Route handleSetTokenPost = (Request request, Response response) -> {
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        if (username == null || game.isUserPlayer(username)) {
            response.status(401);
            return null;
        } else {
            String json = request.body();
            SetTokenPayload setTokenPayload = jsonMapper.readValue(json, SetTokenPayload.class);
            JsonResponse jsonResponse = game.handleSetToken(username, setTokenPayload);
            response.status(jsonResponse.status);
            return new JSONObject().put("msg", jsonResponse.msg);
        }
    };

    public static Route handleStartGamePost = (Request request, Response response) -> {
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        if (username == null || game.isUserPlayer(username)) {
            response.status(401);
            return null;
        } else {
            String json = request.body();
            StartGamePayload startGamePayload = jsonMapper.readValue(json, StartGamePayload.class);
            JsonResponse jsonResponse = game.handleStartGame(username, startGamePayload);
            response.status(jsonResponse.status);
            return new JSONObject().put("msg", jsonResponse.msg);
        }
    };

    public static Route handleMovePost = (Request request, Response response) -> {
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        if (username == null || game.isUserPlayer(username)) {
            response.status(401);
            return null;
        } else {
            String json = request.body();
            MovePayload movePayload = jsonMapper.readValue(json, MovePayload.class);
            Player player = game.players.get(username);
            JsonResponse jsonResponse = game.handleMove(player, movePayload);
            response.status(jsonResponse.status);
            return new JSONObject().put("msg", jsonResponse.msg);
        }
    };

    public static Route handleEndTurnPost = (Request request, Response response) -> {
        String username = request.session().attribute(RequestUtil.CURRENT_USER);
        if (username == null || game.isUserPlayer(username)) {
            response.status(401);
            return null;
        } else {
            String json = request.body();
            EndTurnPayload endTurnPayload = jsonMapper.readValue(json, EndTurnPayload.class);
            JsonResponse jsonResponse = game.handleEndTurn(username, endTurnPayload);
            response.status(jsonResponse.status);
            return new JSONObject().put("msg", jsonResponse.msg);
        }
    };


}
