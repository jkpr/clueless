package app.util;

/**
 * Created by james on 11/25/16.
 */
public class Path {

    public static final String STATIC = "/public";

    public static class Web {
        public static final String INDEX = "/";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String SIGNUP = "/signup";
        public static final String USER = "/user";
        public static final String GAME_LOBBY = "/game";
        public static final String GAME = "/game/:id";
        public static final String FORGOTPASSWORD = "/forgotpassword";
    }

    public static class Template {
        public static final String DIR = "/freemarker";
        public static final String INDEX = "/index.ftl";
        public static final String FOOTER = "/footer.ftl";
        public static final String LOGIN = "/login.ftl";
        public static final String FORGOTPASSWORD = "/forgotpassword.ftl";
        public static final String SIGNUP = "/signup.ftl";
    }
}
