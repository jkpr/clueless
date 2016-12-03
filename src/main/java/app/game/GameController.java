package app.game;

import app.message.Chat;
import app.message.Messaging;
import app.util.Path;
import app.util.RequestUtil;
import app.util.ViewUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by james on 11/26/16.
 */
public class GameController {
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    public static Route serveGameLobby = (Request request, Response response) -> {
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
}
