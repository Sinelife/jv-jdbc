package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String CANT_LOAD_JDBC_DRIVER_MESSAGE
            = "Can't load JDBC driver to MySQL";
    private static final String CANT_CREATE_CONNECTION_MESSAGE
            = "Can't creat connection to DB";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String USER_VALUE = "root";
    private static final String PASSWORD_VALUE = "1234567890";
    private static final String JDBC_CONNECTION_INFO
            = "jdbc:mysql://localhost:3306/manufacturer_db";
    private static final String DRIVER_LOCATION = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER_LOCATION);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(CANT_LOAD_JDBC_DRIVER_MESSAGE, e);
        }

    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put(USER, USER_VALUE);
            dbProperties.put(PASSWORD, PASSWORD_VALUE);
            return DriverManager.getConnection(JDBC_CONNECTION_INFO, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException(CANT_CREATE_CONNECTION_MESSAGE, e);
        }
    }
}
