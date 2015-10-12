package ua.com.juja.sqlcmd.datasource.impl;

import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.constants.Constants;
import ua.com.juja.sqlcmd.datasource.PostgresJDBC;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DataSetImpl;

import java.sql.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PostgresJDBCImpl implements PostgresJDBC, Constants {
    private static final Logger LOG = Logger.getLogger(PostgresJDBCImpl.class);
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement selectTableNames;
    private PreparedStatement selectTable;
    private PreparedStatement insertTable;
    private PreparedStatement cleareTable;

    public PostgresJDBCImpl(String database, String userName, String password) {
        try {
            Class.forName(DRIVER_POSTGRES);
            connection = DriverManager.getConnection(CONNECTING_URL + database, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<DataSet> getTableData(String tableName) {
        List<DataSet> list = new LinkedList<>();
        try {
            selectTable = connection.prepareStatement("SELECT * FROM public." + tableName);
            resultSet = selectTable.executeQuery();
            while (resultSet.next()) {
                DataSet dataSet = new DataSetImpl();
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                dataSet.put(name, password);
                list.add(dataSet);
            }

        } catch (SQLException e) {
            LOG.error("List<DataSet> getTableData(String tableName) -> " + e.getMessage());
        }
        return list;
    }

    @Override
    public Set<String> getTableNames() {
        Set<String> result = new HashSet<>();
        try {
            selectTableNames = connection.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'");
            resultSet = selectTableNames.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString("table_name"));
            }
        } catch (SQLException e) {
            LOG.error("Set<String> getTableNames() -> " + e.getMessage());
        }
        return result;
    }

    @Override
    public void create(String tableName, DataSet input) {
        try {
            insertTable = connection.prepareStatement("INSERT INTO public." + tableName + " (name, password) VALUES (? , ?)");
            insertTable.setString(1, input.getNames().toString());
            insertTable.setString(2, input.getValues().toString());
            insertTable.executeUpdate();
        } catch (SQLException e) {
            LOG.error("create(String tableName, DataSet input) -> " + e.getMessage());
        }

    }

    @Override
    public void clear(String tableName) {
        try {
            cleareTable = connection.prepareStatement("TRUNCATE TABLE " + tableName + " RESTART IDENTITY CASCADE");
            cleareTable.execute();
        } catch (SQLException e) {
            LOG.error("clear(String tableName) -> " + e.getMessage());
        }

    }
}
