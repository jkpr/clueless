package app.message;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

import static j2html.TagCreator.*;

/**
 * Created by james on 12/2/16.
 */
public class Messaging {
    public static Map<Session, String> sessionUsernameMap = new ConcurrentHashMap<>();

    public static Map<Session, String> sessionMap = new ConcurrentHashMap<>();
    public static Map<String, String> usernameMap = new ConcurrentHashMap<>();

    static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();

    public static void sendChat(String sender, String message) {

    }

    //Sends a message from one user to all users, along with a list of current usernames
    public static void broadcastMessage(String sender, String message) {
        sessionUsernameMap.keySet().stream().filter(Session::isOpen).forEach(session -> {
            try {
                session.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("userMessage", createHtmlMessageFromSender(sender, message))
                        .put("userlist", sessionUsernameMap.values())
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void broadcastChat(String sender, String message) {
        broadcastMessage(sender, message);
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
