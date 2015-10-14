package ua.com.juja.sqlcmd.model;

import ua.com.juja.sqlcmd.model.sample.InMemoryDatabaseManager;

/**
 * Created by oleksandr.baglai on 25.08.2015.
 */
public class InMemoryDatabaseManagerTest extends DatabaseManagerTest {

    @Override
    public DatabaseManager getDatabaseManager() {
        return new InMemoryDatabaseManager();
    }
}
