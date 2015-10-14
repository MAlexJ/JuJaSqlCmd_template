package ua.com.juja.sqlcmd.model;

import ua.com.juja.sqlcmd.model.sample.JDBCDatabaseManager;

/**
 * Created by oleksandr.baglai on 25.08.2015.
 */
public class JDBCDatabaseManagerTest extends DatabaseManagerTest {

    @Override
    public DatabaseManager getDatabaseManager() {
        return new JDBCDatabaseManager();
    }
}
