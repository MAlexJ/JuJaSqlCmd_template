package ua.com.juja.sqlcmd.datasource;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.com.juja.sqlcmd.constants.Constants;
import ua.com.juja.sqlcmd.datasource.impl.PostgresJDBCImpl;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.impl.DataSetImpl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPosgresJDBC implements Constants {

    public final String CONNECTING_URL = "sqlcmd";
    public final String USER = "postgres";
    public final String PASSWORD = "postgres";
    public final String TABLE_NAME = "user";
    public DataSet result;
    public List<DataSet> tableData;
    public PostgresJDBC postgresJDBC;

    @Before
    public void init() {
        System.out.println("Open connection");
        postgresJDBC = new PostgresJDBCImpl();
        postgresJDBC.connect(CONNECTING_URL, USER, PASSWORD);
        result = new DataSetImpl();
        result.put("name", "Alex");
        result.put("password", "12345");
        result.put("id", 12);
        postgresJDBC.clear(TABLE_NAME);
    }

    @After
    public void close() {
        System.out.println("Close connection -> " + postgresJDBC.close() + "\n");
    }


    @Test
    public void testGetTableData() {
        postgresJDBC.create(TABLE_NAME, result);
        tableData = postgresJDBC.getTableData(TABLE_NAME);
        assertTrue(getFirstElemListGetValue(tableData).contains("Alex"));
        assertEquals(result.getNames(), getFirstElemListGetName(tableData));
    }

    @Test
    public void testCreate() {
        postgresJDBC.create(TABLE_NAME, result);
        tableData = postgresJDBC.getTableData(TABLE_NAME);
        assertTrue(getFirstElemListGetValue(tableData).contains("12345"));
    }

    @Test
    public void testGetTableNames() {
        Set<String> tableNames = postgresJDBC.getTableNames();
        assertTrue(tableNames.contains(TABLE_NAME));
    }

    @Test
    public void testClear() {
        postgresJDBC.clear(TABLE_NAME);
        tableData = postgresJDBC.getTableData(TABLE_NAME);
        assertEquals(0, tableData.size());
    }

    @Test
    public void testUpdate() {
        postgresJDBC.create(TABLE_NAME, result);
        DataSet result = getFirstElemList(postgresJDBC.getTableData(TABLE_NAME));

        int id = (int) result.get(ID);

        DataSet input = new DataSetImpl();
        input.put("name", "Max");
        input.put("password", "54321");
        input.put("id", id);

        postgresJDBC.update(TABLE_NAME, id, input);
        assertEquals(input.getValues(), getFirstElemListGetValue(postgresJDBC.getTableData(TABLE_NAME)));
    }


    @Test
    public void testClose() {
        assertTrue(postgresJDBC.close());
    }

    public DataSet getFirstElemList(List<DataSet> dataSets) {
        return dataSets.get(0);

    }

    public Collection<Object> getFirstElemListGetValue(List<DataSet> dataSets) {
        DataSet dataSet = dataSets.get(0);
        return dataSet.getValues();
    }

    public Set<String> getFirstElemListGetName(List<DataSet> dataSets) {
        DataSet dataSet = dataSets.get(0);
        return dataSet.getNames();
    }


}
