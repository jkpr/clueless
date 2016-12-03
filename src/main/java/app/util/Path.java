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
        public static final String MESSAGE = "/message";
    }

    public static class Action {
        public static final String JOIN = "/game/:id/join";
        public static final String DISPROVE_SUGGESTION = "/game/:id/disprove";
        public static final String END_TURN = "/game/:id/endturn";
        public static final String MAKE_ACCUSATION = "/game/:id/accuse";
        public static final String MAKE_SUGGESTION = "/game/:id/suggest";
        public static final String MOVE = "/game/:id/move";
        public static final String SET_TOKEN = "/game/:id/token";
        public static final String START_GAME = "/game/:id/start";
    }

    public static class Template {
        public static final String DIR = "/freemarker";
        public static final String INDEX = "/index.ftl";
        public static final String FOOTER = "/footer.ftl";
        public static final String LOGIN = "/login.ftl";
        public static final String GAME_LOBBY = "/lobby.ftl";
        public static final String GAME = "/game.ftl";
    }
}
