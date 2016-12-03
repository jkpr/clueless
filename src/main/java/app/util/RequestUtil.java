package app.util;

import java.net.HttpCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;

import java.util.List;

/**
 * Created by james on 12/1/16.
 */
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    public static String USERNAME = "username";
    public static String PASSWORD = "password";
    public static String CURRENT_USER = "currentUser";
    public static String LOGIN_REDIRECT = "loginRedirect";
    public static String SESSION_ID = "JSESSIONID";

    public static String getQueryUsername(Request request) {
        return request.queryParams(USERNAME);
    }

    public static String getQueryPassword(Request request) {
        return request.queryParams(PASSWORD);
    }

    public static String getQueryLoginRedirect(Request request) {
        return request.queryParams("loginRedirect");
    }

    public static String getSessionId(List<HttpCookie> cookies) {
        String sessionId = null;
        for (HttpCookie cookie : cookies) {
            if (cookie.getName().equals(SESSION_ID)) {
                sessionId = cookie.getValue();
            }
        }
        return sessionId;
    }
}
