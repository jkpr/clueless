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
    public static String EMAIL = "email";
    public static String QUERY_TYPE = "type";
    public static String JSON = "json";
    public static String TEXT = "txt";
    public static String CURRENT_USER = "currentUser";
    public static String SESSION_ID = "JSESSIONID";
    public static String GREEN_MSG = "greenMsg";
    public static String RED_MSG = "redMsg";

    public static String getQueryUsername(Request request) {
        return request.queryParams(USERNAME);
    }

    public static String getQueryPassword(Request request) {
        return request.queryParams(PASSWORD);
    }

    public static String getQueryEmail(Request request) {
        return request.queryParams(EMAIL);
    }

    public static String getQueryType(Request request) {
        return request.queryParams(QUERY_TYPE);
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
