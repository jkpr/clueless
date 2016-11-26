package app;

import app.database.DatabaseConnection;
import app.index.IndexController;
import app.util.Path;
import app.util.ViewUtil;
import spark.Spark;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class Application
{

    private static int views = 0;

    public static void main( String[] args )
    {
        // Initialize Spark
        Spark.port(getHerokuAssignedPort());
        Spark.staticFileLocation(Path.STATIC);
        ViewUtil.initializeFreeMarker();

        // Initialize Database
        DatabaseConnection.initializeConnection(getHerokuDb());


        // Initialize routes
        Spark.get(Path.Web.INDEX, IndexController.serveIndexPage);




        Spark.get("/count", (req, res) -> {
            views++;
            return "<h1>Hello SparkJava World!</h1><p>Views: " + String.valueOf(views) + "</p>";
        });
    }

    static int getHerokuAssignedPort() {
        int port = 4567;

        String envPort = System.getenv().get("PORT");
        if (envPort != null) {
            port = Integer.parseInt(envPort);
        }

        //return default port if environment variable not set (i.e. on localhost)
        return port;

    }

    static String getHerokuDb() {
        String db = "postgresql://localhost:5432/mydb";

        String envDb = System.getenv().get("DATABASE_URL");
        if (envDb != null) {
            db = envDb;
        }

        // return default db if environment variable not set
        return db;
    }
}
