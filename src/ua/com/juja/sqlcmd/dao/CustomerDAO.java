package ua.com.juja.sqlcmd.dao;


import java.util.Collection;
import java.util.Map;

/**
 * Created by ION on 06.10.2015.
 */
public interface CustomerDAO {

    //��� ��������� ������ ���� ������ ����, � ������� ������������
    public Collection selectAllTablesCustomer();

    //��� ������� ���� �������
    public boolean deleteTableCustomer(String tablName);

    //��� �������� ������ � �������  -> create|tableName|column1|value1|column2|value2|...|columnN|valueN
    public int insertCustomer(String tableName, Map<String, String> value);

   //��� ��������� ����������� ������� 'tableName'
   public Collection findCustomer(String tablName);

}