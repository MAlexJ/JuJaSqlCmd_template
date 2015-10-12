package ua.com.juja.sqlcmd.dao.impl;

import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.datasource.PostgresJDBC;
import ua.com.juja.sqlcmd.datasource.impl.PostgresJDBCImpl;
import ua.com.juja.sqlcmd.model.DataSet;


import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class PostgresSqlCustomerDAOImpl implements CustomerDAO {

    private PostgresJDBC postgresJDBC;


    @Override
    public void connect(String database, String userName, String password) {
        this.postgresJDBC = new PostgresJDBCImpl(database, userName, password);
    }

    @Override
    public Set<String> getTableNames() {
        return this.postgresJDBC.getTableNames();
    }

    @Override
    public Collection<DataSet> find(String tablName) {
        return this.postgresJDBC.getTableData(tablName);
    }

    @Override
    public void clear(String tableName) {
        this.postgresJDBC.clear(tableName);
    }


    @Override
    public void create(String tableName, DataSet input) {
        this.postgresJDBC.create(tableName, input);
    }




}
