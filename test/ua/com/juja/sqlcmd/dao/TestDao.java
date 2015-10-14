package ua.com.juja.sqlcmd.dao;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.sqlcmd.model.DataSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestDao {
    DAOFactory daoFactory;
    CustomerDAO dao;
    DataSet dataSet;
    int id;

    @Before
    public void initParam() {
        this.daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
        this.dao = mock(CustomerDAO.class);
        this.dataSet = mock(DataSet.class);
        this.id = 1;
    }

    @Test
    public void methodInvocationCustomerTest() {
        //Perform
        dao.connect("DB", "USER", "PASS");
        dao.getTableNames();
        dao.getTableData("getTableData");
        dao.clear("clear");
        dao.create("create", dataSet);
        dao.update("update", id, dataSet);
        dao.getTableColumns("getTableColumns");
        dao.isConnected();

        //Compare
        verify(dao).clear("clear");
        verify(dao).getTableData("getTableData");
        verify(dao).getTableNames();
        verify(dao).connect("DB", "USER", "PASS");
        verify(dao).create("create", dataSet);
        verify(dao).update("update", id, dataSet);
        verify(dao).getTableColumns("getTableColumns");
        verify(dao).isConnected();
    }
}
