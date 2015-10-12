package ua.com.juja.sqlcmd.datasource;


import ua.com.juja.sqlcmd.model.DataSet;

import java.util.List;
import java.util.Set;

public interface PostgresJDBC {

    List<DataSet> getTableData(String tableName);

    Set<String> getTableNames();

    void create(String tableName, DataSet input);

    void clear(String tableName);

}
