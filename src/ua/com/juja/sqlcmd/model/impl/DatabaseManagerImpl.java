package ua.com.juja.sqlcmd.model.impl;

import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.dao.DAOFactory;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DatabaseManager;

import java.util.List;
import java.util.Set;

/**
 * Created by ION on 14.10.2015.
 */
public class DatabaseManagerImpl implements DatabaseManager {
    private CustomerDAO dao;

    public DatabaseManagerImpl() {
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
        return this.dao.close();
    }
}
