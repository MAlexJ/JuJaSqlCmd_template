package ua.com.juja.sqlcmd.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by oleksandr.baglai on 02.10.2015.
 */
public interface DataSet {
    void put(String name, Object value);

    Collection<Object> getValues();

    Set<String> getNames();

    Object get(String name);

    void updateFrom(DataSet newValue);
}
