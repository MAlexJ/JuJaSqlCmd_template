package ua.com.juja.sqlcmd.dataset;


import org.junit.Before;
import org.junit.Test;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.impl.DataSetImpl;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDataSet {

    DataSet dataSet = new DataSetImpl();

    @Before
    public void init() {
        dataSet.put("name", "Alex");
        dataSet.put("password", "12345");
        dataSet.put("id", 12);
    }

    @Test
    public void testPut() {
        assertEquals("[name, password, id]", dataSet.getNames().toString());
        assertEquals("[Alex, 12345, 12]", dataSet.getValues().toString());
    }


    @Test
    public void testGetValues() {
        List<Object> strings = new ArrayList<>();
        strings.add("Alex");
        strings.add("12345");
        strings.add(12);
        assertEquals(strings, dataSet.getValues());
    }

    @Test
    public void testGetNames() {
        Set<String> strings = new HashSet<>();
        strings.add("name");
        strings.add("password");
        strings.add("id");
        assertEquals(strings, dataSet.getNames());
    }

    @Test
    public void testGet() {
        assertEquals("Alex", dataSet.get("name"));
        assertEquals("12345", dataSet.get("password"));
        assertEquals(12, dataSet.get("id"));
    }
}
