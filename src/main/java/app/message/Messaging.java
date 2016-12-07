package app.message;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

import static app.Application.game;

import static j2html.TagCreator.*;

/**
 * Created by james on 12/2/16.
 */
public class Messaging {
    private static final Logger logger = LoggerFactory.getLogger(Messaging.class);

    public static final String TYPE = "type";
    public static final String DATA = "data";
    // Message types
    public static final String CHAT = "chat";
    public static final String GAME = "game";
    public static final String ACTION = "action";
    // Action fields
    public static final String CHARACTER = "character";
    public static final String NOTIFICATION = "notification";
    public static final String BOARD = "board";
    public static final String STATUS = "status";
    public static final String STATUS_MESSAGE = "statusMessage";
    // Chat fields
    public static final String USER_MESSAGE = "usermessage";
    public static final String USER_LIST = "userlist";

    public static Map<Session, String> sessionUsernameMap = new ConcurrentHashMap<>();

    public static Map<Session, String> sessionMap = new ConcurrentHashMap<>();
    public static Map<String, String> usernameMap = new ConcurrentHashMap<>();

    static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();

    public static void sendChat(String sender, String message) {

    }

    public static void broadcastOnActionSuccess() {
        sessionUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                JSONObject data = new JSONObject()
                        .put(TYPE, ACTION)
                        .put(DATA, game.getGameForUser(sessionUsernameMap.get(session)));
                session.getRemote().sendString(String.valueOf(data));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void broadcastGame() {
        sessionUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                JSONObject data = new JSONObject()
                        .put(TYPE, GAME)
                        .put(DATA, game.getVisualModel());
                session.getRemote().sendString(String.valueOf(data));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    //Sends a message from one user to all users, along with a list of current usernames
    public static void broadcastMessage(String sender, String message) {
        sessionUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                JSONObject data = new JSONObject()
                        .put(USER_MESSAGE, createHtmlMessageFromSender(sender, message))
                        .put(USER_LIST, sessionUsernameMap.values());
                JSONObject msg = new JSONObject()
                        .put(TYPE, CHAT)
                        .put(DATA, data);
                session.getRemote().sendString(String.valueOf(msg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void broadcastChat(String sender, String message) {
        sessionUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                JSONObject data = new JSONObject()
                        .put(USER_MESSAGE, createHtmlMessageFromSender(sender, message))
                        .put(USER_LIST, sessionUsernameMap.values());
                JSONObject msg = new JSONObject()
                        .put(TYPE, CHAT)
                        .put(DATA, data);
                session.getRemote().sendString(String.valueOf(msg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void broadcastJoinChat(String user) {
        String sender = "Server";
        String msg = user + " joined the chat";
        broadcastChat(sender, msg);
    }

    public static void broadcastLeaveChat(String user) {
        String sender = "Server";
        String msg = user + " left the chat";
        broadcastChat(sender, msg);
    }

    //Builds a HTML element with a sender-name, a message, and a timestamp,
    private static String createHtmlMessageFromSender(String sender, String message) {
        return article().with(
                b(sender + " says:"),
                p(message),
                span().withClass("timestamp").withText(new SimpleDateFormat("HH:mm:ss").format(new Date()))
        ).render();
    }
}
