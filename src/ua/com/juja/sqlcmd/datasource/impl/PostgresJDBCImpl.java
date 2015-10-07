package ua.com.juja.sqlcmd.datasource.impl;

import ua.com.juja.sqlcmd.datasource.PostgresJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresJDBCImpl implements PostgresJDBC {
    private Connection connection;
    private Statement statement;

    public void connect(String database, String userName, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(database, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeConnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void clear(String tableName) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM " + tableName);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
