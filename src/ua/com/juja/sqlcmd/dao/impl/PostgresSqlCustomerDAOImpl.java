package ua.com.juja.sqlcmd.dao.impl;

import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.datasource.DataServicePostgresSql;
import ua.com.juja.sqlcmd.datasource.impl.DataServicePostgresSqlImpl;

import java.util.Collection;
import java.util.Map;

public class PostgresSqlCustomerDAOImpl implements CustomerDAO {

    private DataServicePostgresSql postgresSql;

    public PostgresSqlCustomerDAOImpl() {
        this.postgresSql = new DataServicePostgresSqlImpl();
    }

    @Override
    public Collection selectAllTablesCustomer() {

        return null;
    }

    @Override
    public boolean deleteTableCustomer(String tablName) {

        return false;
    }

    @Override
    public int insertCustomer(String tableName, Map<String, String> value) {

        return 0;
    }

    @Override
    public Collection findCustomer(String tablName) {

        return null;
    }
}
