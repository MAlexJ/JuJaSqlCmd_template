package ua.com.juja.sqlcmd.dao.impl;

import ua.com.juja.sqlcmd.constants.Constants;
import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.dao.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ION on 07.10.2015.
 */
public class PostgresSqlDAOFactoryImpl implements DAOFactory, Constants {


    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTING_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return new PostgresSqlCustomerDAOImpl();
    }
}
