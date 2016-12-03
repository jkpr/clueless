package app.message;

import app.util.RequestUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.net.HttpCookie;
import java.util.List;

import static app.Application.game;

/**
 * Created by james on 12/2/16.
 */
@WebSocket
public class MessageWebSocketHandler {
    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        List<HttpCookie> cookies = session.getUpgradeRequest().getCookies();
        String sessionId = RequestUtil.getSessionId(cookies);

        Messaging.userUsernameMap.put(session, sessionId);
        Messaging.broadcastMessage(sender = "Server", msg = (sessionId + " joined the chat"));
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        Messaging.broadcastMessage(sender = "Server", msg = (Messaging.userUsernameMap.get(session) + " left the chat"));
        Messaging.userUsernameMap.remove(session);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) {
        Messaging.broadcastMessage(sender = Messaging.userUsernameMap.get(session), msg = message);
    }
}
