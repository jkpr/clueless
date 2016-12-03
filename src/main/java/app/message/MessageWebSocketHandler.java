package app.message;

import app.util.RequestUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.UpgradeHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.RequestResponseFactory;

import java.net.HttpCookie;
import java.util.List;

import static app.Application.game;

/**
 * Created by james on 12/2/16.
 */
@WebSocket
public class MessageWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(MessageWebSocketHandler.class);

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        List<HttpCookie> cookies = session.getUpgradeRequest().getCookies();
        String username = Messaging.sessionUsernameMap.get(session);
        if (username != null) {
            logger.info("Connecting websocket with known session and username: {}", username);
        } else {
            String sessionId = RequestUtil.getSessionId(cookies);
            String newUsername = Messaging.usernameMap.get(sessionId);
            if (newUsername != null) {
                logger.info("Connecting websocket for new user: {}", newUsername);
                Messaging.sessionUsernameMap.put(session, newUsername);
                Messaging.broadcastJoinChat(newUsername);
            } else {
                logger.info("Connecting websocket with session id (unknown username): {}", sessionId);
                Messaging.sessionMap.put(session, sessionId);
            }
        }
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        String username = Messaging.sessionUsernameMap.get(session);
        Messaging.sessionUsernameMap.remove(session);
        Messaging.broadcastLeaveChat(username);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) {
        Messaging.broadcastChat(sender = Messaging.sessionUsernameMap.get(session), msg = message);
    }
}
