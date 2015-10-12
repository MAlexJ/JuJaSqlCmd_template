package ua.com.juja.sqlcmd.model;

import java.util.*;

public class DataSetImpl implements DataSet {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public void put(String name, Object value) {
        this.map.put(name, value);
    }

    @Override
    public List<Object> getValues() {
        List list;
        Collection<Object> collection = map.values();
        if (collection instanceof List)
            list = (List) collection;
        else
            list = new ArrayList(collection);
        return list;
    }

    @Override
    public Set<String> getNames() {
        return map.keySet();
    }

    @Override
    public Object get(String name) {
        return this.map.get(name);
    }


    @Override
    public void updateFrom(DataSet newValue) {
        map.clear();
        DataSet dataSet = new DataSetImpl();

        // TODO STRATEGY

    }

    @Override
    public Set<Map.Entry<String, Object>> getSetEntry() {
        return this.map.entrySet();
    }

}
