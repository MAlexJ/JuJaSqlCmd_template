package ua.com.juja.sqlcmd.dao.test;

import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.dao.DAOFactory;

/**
 * Created by ION on 07.10.2015.
 */
public class TestMain {

    public static void main(String[] args) {

        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);

        CustomerDAO dao = daoFactory.getCustomerDAO();

        dao.deleteTableCustomer("");
        dao.findCustomer("");
        dao.insertCustomer(null,null);
        dao.selectAllTablesCustomer();



    }
}
