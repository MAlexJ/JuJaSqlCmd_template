package ua.com.juja.sqlcmd.dao;


import ua.com.juja.sqlcmd.model.DataSet;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CustomerDAO {

    List<DataSet> getTableData(String tableName);

    boolean close();

    Set<String> getTableNames();

    void connect(String database, String userName, String password);

    void clear(String tableName);

    void create(String tableName, DataSet input);

    void update(String tableName, int id, DataSet newValue);

    Set<String> getTableColumns(String tableName);

    boolean isConnected();

}