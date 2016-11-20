package edu.jhu.boddybuilders;

import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Spark.get("/", (req, res) -> "<h1>Hello SparkJava World!</h1>");
    }
}
