package ua.com.juja.sqlcmd.dao;


import ua.com.juja.sqlcmd.model.DataSet;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface CustomerDAO {

    //��� ��������� connect � ��
    public void connect(String database, String userName, String password);

    //��� ��������� ������ ���� ������ ����, � ������� ������������
    public Set<String> getTableNames();

    //��� ��������� ����������� ������� 'tableName'
    public Collection<DataSet> find(String tablName);


    //��� ������� ���� �������
    void clear(String tableName);

    //��� �������� ������ � �������  -> create|tableName|column1|value1|column2|value2|...|columnN|valueN
    void create(String tableName, DataSet input);



}