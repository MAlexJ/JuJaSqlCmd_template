package ua.com.juja.sqlcmd.dao;

import org.junit.Test;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestDao {
    @Test
    public void methodInvocationCustomerTest() {
        //given
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
        CustomerDAO dao = mock(CustomerDAO.class);

        //when
        dao.selectAllTablesCustomer();
        dao.findCustomer("find");
        dao.deleteTableCustomer("delete");
        dao.insertCustomer("tableNAme",new HashMap<>());

        //then
        verify(dao).selectAllTablesCustomer();
        verify(dao).findCustomer("find");
        verify(dao).deleteTableCustomer("delete");
        verify(dao).insertCustomer("tableNAme",new HashMap<>());

    }

}
