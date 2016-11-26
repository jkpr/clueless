package app.database;

import org.apache.commons.dbcp2.BasicDataSource;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by james on 11/25/16.
 */
public class DatabaseConnection {
    private static final int N_CONNECTIONS = 10;

    private static BasicDataSource connectionPool;
    
    public static void initializeConnection(String Uri) {
        if (connectionPool != null) {
            return;
        }

        try {
            URI dbUri = new URI(Uri);
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
            connectionPool = new BasicDataSource();

            if (dbUri.getUserInfo() != null) {
                connectionPool.setUsername(dbUri.getUserInfo().split(":")[0]);
                connectionPool.setPassword(dbUri.getUserInfo().split(":")[1]);
            }

            connectionPool.setDriverClassName("org.postgresql.Driver");
            connectionPool.setUrl(dbUrl);
            connectionPool.setInitialSize(N_CONNECTIONS);

            // Ensure tables exist
            assert_users();


        } catch (URISyntaxException e) {
            // Unable to parse supplied URI
        } catch (SQLException e) {
            // error with the tables
        }
    }

    private static void assert_users() throws SQLException {
        Connection connection = connectionPool.getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(DatabaseContract.Users.CREATE_TABLE);
    }


}
