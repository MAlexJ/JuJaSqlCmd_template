package ua.com.juja.sqlcmd.dataset;


import org.junit.Before;
import org.junit.Test;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DataSetImpl;

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
        dataSet.put("Alex", "12345");
    }

    @Test
    public void testPut() {
        assertTrue(dataSet.getNames().contains("Alex"));
        assertTrue(dataSet.getValues().contains("12345"));
    }


    @Test
    public void testGetValues() {
        List<String> strings = new ArrayList<>();
        strings.add("12345");
        assertEquals(strings, dataSet.getValues());
    }

    @Test
    public  void testGetNames(){
        Set<String> strings = new HashSet<>();
        strings.add("Alex");
        assertEquals(strings, dataSet.getNames());
    }

    @Test
    public  void testGet(){

        assertEquals("12345", dataSet.get("Alex"));
    }



}
