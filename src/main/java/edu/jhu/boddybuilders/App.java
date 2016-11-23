package edu.jhu.boddybuilders;

import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int views = 0;

    public static void main( String[] args )
    {
        Spark.port(getHerokuAssignedPort());
        Spark.get("/", (req, res) -> {
            views++;
            return "<h1>Hello SparkJava World!</h1><p>Views: " + String.valueOf(views) + "</p>";
        });
    }

    // Found on https://sparktutorials.github.io/2015/08/24/spark-heroku.html
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
