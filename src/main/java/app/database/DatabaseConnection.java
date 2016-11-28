package app.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by james on 11/25/16.
 */
public class DatabaseConnection {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private final int N_CONNECTIONS = 6;

    private BasicDataSource connectionPool;

    public DatabaseConnection(String Uri) {
        initializeConnection(Uri);
    }

    private void initializeConnection(String Uri) {
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
            logger.warn("Unable to parse DB URI '{}'", Uri);
        }
    }

    private void assert_users() {
        try {
            Connection connection = connectionPool.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(DatabaseContract.Users.CREATE_TABLE);
        } catch (SQLException e) {
            logger.warn("SQL exception with 'users' table: '{}'", e.getMessage());
        }
    }


}
