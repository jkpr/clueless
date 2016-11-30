package app.database;

/**
 * Created by james on 11/25/16.
 */
public class DatabaseContract {
    private DatabaseContract() {};

    public static final int DATABASE_VERSION = 1;

    public static abstract class Users {
        public static final String TABLE_NAME = "users";

        public static final String USERNAME = "username";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String API_KEY = "api_key";
        public static final String GAMES_WON = "games_won";
        public static final String GAMES_PLAYED = "games_played";
        public static final String LAST_LOGIN = "last_login";
        public static final String CREATE_DATE = "create_date";
        public static final String MODIFY_DATE = "modify_date";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                USERNAME + " varchar(50) NOT NULL UNIQUE, " +
                EMAIL + " varchar(50), " +
                PASSWORD + " varchar(50), " +
                API_KEY + " varchar(50), " +
                GAMES_WON + " integer DEFAULT 0, " +
                GAMES_PLAYED + " integer DEFAULT 0, " +
                LAST_LOGIN + " timestamp, " +
                CREATE_DATE + " timestamp DEFAULT CURRENT_TIMESTAMP, " +
                MODIFY_DATE + " timestamp);";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
