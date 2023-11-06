package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private Connection connection;
    private String DB_URL ="10.100.0.95";
    private String DB_USERNAME = "web-test";
    private String DB_PASSWORD = "tlsm76!lgn2017#!";
    public DBWorker() {


        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
