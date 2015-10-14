package ua.com.juja.sqlcmd.dao;


import ua.com.juja.sqlcmd.model.DataSet;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CustomerDAO {

    //Get the contents of the table 'tableName'.
    List<DataSet> getTableData(String tableName);

    boolean close();

    //Get a list of all tables in the database that is connected.
    Set<String> getTableNames();

    //Connect to the database.
    void connect(String database, String userName, String password);

    //Cleaning the selected table.
    void clear(String tableName);

    //Writing in the table.  -> create|tableName|column1|value1|column2|value2|...|columnN|valueN
    void create(String tableName, DataSet input);

    void update(String tableName, int id, DataSet newValue);

    Set<String> getTableColumns(String tableName);

    boolean isConnected();

}