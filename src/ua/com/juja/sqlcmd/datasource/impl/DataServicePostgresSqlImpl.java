package ua.com.juja.sqlcmd.datasource.impl;

import ua.com.juja.sqlcmd.datasource.DataServicePostgresSql;

/**
 * Created by ION on 07.10.2015.
 */
public class DataServicePostgresSqlImpl implements DataServicePostgresSql {

    //Connectin to DB

    public DataServicePostgresSqlImpl() {
        System.err.println("Connection DB PSQL");
    }
}
