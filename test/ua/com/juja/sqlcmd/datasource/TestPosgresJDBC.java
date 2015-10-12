package ua.com.juja.sqlcmd.datasource;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.com.juja.sqlcmd.datasource.impl.PostgresJDBCImpl;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DataSetImpl;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPosgresJDBC {

    public final String CONNECTING_URL = "sqlcmd";
    public final String USER = "postgres";
    public final String PASSWORD = "postgres";
    public final String TABLE_NAME = "account";
    public DataSet result;
    public List<DataSet> tableData;


    PostgresJDBC postgresJDBC;

    @Before
    public void init() {
        System.out.println("Open connection");
        postgresJDBC = new PostgresJDBCImpl(CONNECTING_URL, USER, PASSWORD);
        result = new DataSetImpl();
        result.put("Asdfg", "12345");
        postgresJDBC.clear(TABLE_NAME);
    }

    @After
    public void close() {
        postgresJDBC.clear(TABLE_NAME);
        System.out.println("Close connection -> " + postgresJDBC.close() + "\n");
    }


    @Test
    public void testGetTableData() {
        postgresJDBC.create(TABLE_NAME, result);
        tableData = postgresJDBC.getTableData(TABLE_NAME);
        assertEquals(result.getValues(), tableData.get(0).getValues());
        assertEquals(result.getNames(), tableData.get(0).getNames());
    }

    @Test
    public void testGetTableNames() {
        Set<String> tableNames = postgresJDBC.getTableNames();
        assertTrue(tableNames.contains(TABLE_NAME));
    }

    @Test
    public void testCreate() {
        postgresJDBC.create(TABLE_NAME, result);
        tableData = postgresJDBC.getTableData(TABLE_NAME);
        assertEquals(result.getValues(), tableData.get(0).getValues());
        assertEquals(result.getNames(), tableData.get(0).getNames());
    }

    @Test
    public void testClear() {
        postgresJDBC.clear(TABLE_NAME);
        tableData = postgresJDBC.getTableData(TABLE_NAME);
        assertEquals(0, tableData.size());
    }
}
