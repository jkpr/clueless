package app;

import app.database.DatabaseConnection;
import app.game.Game;
import app.game.GameController;
import app.index.IndexController;
import app.login.LoginController;
import app.signup.SignupController;
import app.message.MessageWebSocketHandler;
import app.user.UserController;
import app.user.UserManager;
import app.util.Path;
import app.util.ViewUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;
import app.gameplay.GamePlayController;

import static spark.Spark.init;
import static spark.Spark.webSocket;

/**
 * Hello world!
 *
 */
public class Application
{
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static DatabaseConnection connectionPool;
    public static ObjectMapper jsonMapper = new ObjectMapper();
    public static UserManager userManager = new UserManager();
    public static Game game;

    public static void main( String[] args )
    {
        // Initialize Spark
        Spark.port(getHerokuAssignedPort());
        Spark.staticFileLocation(Path.STATIC);
        ViewUtil.initializeFreeMarker();

        // Initialize Database, JSON mapper, UserManager, GameManager
        connectionPool = new DatabaseConnection(getHerokuDb());
        game = new Game();

        // Initialize routes
        webSocket(Path.Web.MESSAGE, MessageWebSocketHandler.class);
        Spark.get(Path.Web.INDEX, IndexController.serveIndexPage);
        Spark.get(Path.Web.LOGIN, LoginController.serveLoginPage);
        Spark.post(Path.Web.LOGIN, LoginController.handleLoginPost);
        Spark.get(Path.Web.LOGOUT, LoginController.handleLogout);
        Spark.get(Path.Web.SIGNUP, SignupController.serveSignupPage);
        Spark.get(Path.Web.FORGOTPASSWORD, UserController.serveForgotpasswordPage);
        Spark.post(Path.Web.FORGOTPASSWORD, UserController.handleForgotpasswordPost);
        Spark.get(Path.Web.GAME_PLAY, GamePlayController.serveGamePlayPage);
        Spark.get(Path.Web.USER, UserController.serveUserPage);
        //Spark.get(Path.Web.GAME_LOBBY, GameController.serveGameLobby);

        // Game Routes
        Spark.get(Path.Web.GAME, GameController.serveGame);
        Spark.post(Path.Action.JOIN, GameController.handleAddPlayerPost);
        Spark.post(Path.Action.SET_TOKEN, GameController.handleSetTokenPost);
        Spark.post(Path.Action.START_GAME, GameController.handleStartGamePost);
        Spark.post(Path.Action.MOVE, GameController.handleMovePost);
        Spark.post(Path.Action.MAKE_SUGGESTION, GameController.handleMakeSuggestionPost);
        Spark.post(Path.Action.DISPROVE_SUGGESTION, GameController.handleDisproveSuggestionPost);
        Spark.post(Path.Action.MAKE_ACCUSATION, GameController.handleMakeAccusationPost);
        Spark.post(Path.Action.END_TURN, GameController.handleEndTurnPost);

        logger.info("Finished app initialization: port, static, freemarker, db, json mapper, routes");
    }

    static int getHerokuAssignedPort() {
        // default port for local development
        int port = 4567;

        // search for environment variable (Heroku)
        String envPort = System.getenv().get("PORT");
        if (envPort != null) {
            port = Integer.parseInt(envPort);
        }

        return port;

    }

    static String getHerokuDb() {
        // default port for local development
        String db = "postgresql://localhost:5432/mydb";

        // search for environment variable (Heroku)
        String envDb = System.getenv().get("DATABASE_URL");
        if (envDb != null) {
            db = envDb;
        }

        return db;
    }
}
