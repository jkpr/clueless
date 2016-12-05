package app;

import app.database.DatabaseConnection;
import app.index.IndexController;
import app.login.LoginController;
import app.forgotpassword.ForgotpasswordController;
import app.signup.SignupController;
import app.user.UserController;
import app.util.Path;
import app.util.ViewUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class Application
{
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static DatabaseConnection connectionPool;
    public static ObjectMapper jsonMapper;

    public static void main( String[] args )
    {
        // Initialize Spark
        Spark.port(getHerokuAssignedPort());
        Spark.staticFileLocation(Path.STATIC);
        ViewUtil.initializeFreeMarker();

        // Initialize Databaseuse
        connectionPool = new DatabaseConnection(getHerokuDb());

        // Initialize JSON mapper
        jsonMapper = new ObjectMapper();

        // Initialize routes
        Spark.get(Path.Web.INDEX, IndexController.serveIndexPage);
        Spark.get(Path.Web.LOGIN, LoginController.serveLoginPage);
        Spark.get(Path.Web.SIGNUP, SignupController.serveSignupPage);
        Spark.get(Path.Web.FORGOTPASSWORD, ForgotpasswordController.serveForgotpasswordPage);
        Spark.get(Path.Web.USER, UserController.serveUserPage);

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
