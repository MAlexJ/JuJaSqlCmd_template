package ua.com.juja.sqlcmd.model;

import ua.com.juja.sqlcmd.model.impl.DatabaseManagerImpl;

/**
 * Created by ION on 14.10.2015.
 */
public class DatabaseManagerImplTest extends DatabaseManagerTest {
    @Override
    public DatabaseManager getDatabaseManager() {
        return new DatabaseManagerImpl();
    }
}
