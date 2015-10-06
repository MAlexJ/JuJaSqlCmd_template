package ua.com.juja.sqlcmd.constants;

import ua.com.juja.sqlcmd.entity.UserDB;

/**
 * Created by ION on 04.10.2015.
 */
public interface Constants {
    public static final String CONNECTING_URL = "jdbc:postgresql://localhost:5432/sqlcmd";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String DRIVER = "org.postgresql.Driver";

    //connect|databaseName|userName|password
    public static final UserDB USER_DB = new UserDB();

    public static final int CONNECTING_POOL_SIZE = 5;

}
