package ua.com.juja.sqlcmd.dao;


import ua.com.juja.sqlcmd.model.DataSet;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface CustomerDAO {

    //для получения connect к БД
    public void connect(String database, String userName, String password);

    //для получения списка всех таблиц базы, к которой подключились
    public Set<String> getTableNames();

    //для получения содержимого таблицы 'tableName'
    public Collection<DataSet> find(String tablName);


    //для очистки всей таблицы
    void clear(String tableName);

    //для создания записи в таблице  -> create|tableName|column1|value1|column2|value2|...|columnN|valueN
    void create(String tableName, DataSet input);



}