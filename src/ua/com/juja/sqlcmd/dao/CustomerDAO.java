package ua.com.juja.sqlcmd.dao;


import java.util.Collection;
import java.util.Map;

/**
 * Created by ION on 06.10.2015.
 */
public interface CustomerDAO {

    //для получения списка всех таблиц базы, к которой подключились
    public Collection selectAllTablesCustomer();

    //для очистки всей таблицы
    public boolean deleteTableCustomer(String tablName);

    //для создания записи в таблице  -> create|tableName|column1|value1|column2|value2|...|columnN|valueN
    public int insertCustomer(String tableName, Map<String, String> value);

   //для получения содержимого таблицы 'tableName'
   public Collection findCustomer(String tablName);

}