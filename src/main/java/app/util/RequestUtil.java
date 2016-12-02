package app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;

/**
 * Created by james on 12/1/16.
 */
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    public static String USERNAME = "username";
    public static String PASSWORD = "password";
    public static String CURRENT_USER = "currentUser";
    public static String LOGIN_REDIRECT = "loginRedirect";

    public static String getQueryUsername(Request request) {
        return request.queryParams(USERNAME);
    }

    public static String getQueryPassword(Request request) {
        return request.queryParams(PASSWORD);
    }

    public static String getQueryLoginRedirect(Request request) {
        return request.queryParams("loginRedirect");
    }
}
