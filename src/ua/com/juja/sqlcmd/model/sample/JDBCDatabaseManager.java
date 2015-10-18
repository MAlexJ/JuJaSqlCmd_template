package ua.com.juja.sqlcmd.model.sample;

import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.dao.DAOFactory;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DatabaseManager;

import java.util.*;

public class JDBCDatabaseManager implements DatabaseManager {
    private CustomerDAO dao;

    public JDBCDatabaseManager() {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
        if (daoFactory != null) {
            this.dao = daoFactory.getCustomerDAO();
        }
    }

    @Override
    public List<DataSet> getTableData(String tableName) {
        return this.dao.getTableData(tableName);
    }

    @Override
    public int getSize(String tableName) {
        //TODO implements
        return 0;
    }

    @Override
    public Set<String> getTableNames() {
        return this.dao.getTableNames();
    }

    @Override
    public void connect(String database, String userName, String password) {
        this.dao.connect(database, userName, password);
    }

    @Override
    public void clear(String tableName) {
        this.dao.clear(tableName);
    }

    @Override
    public void create(String tableName, DataSet input) {
        this.dao.create(tableName, input);
    }

    @Override
    public void update(String tableName, int id, DataSet newValue) {
        this.dao.update(tableName, id, newValue);
    }

    @Override
    public Set<String> getTableColumns(String tableName) {
        return this.dao.getTableColumns(tableName);
    }

    @Override
    public boolean isConnected() {
        return this.dao.isConnected();
    }

    @Override
    public boolean close() {
        return  this.dao.close();
    }
}
