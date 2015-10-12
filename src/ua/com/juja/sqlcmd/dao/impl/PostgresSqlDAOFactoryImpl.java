package ua.com.juja.sqlcmd.dao.impl;


import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.dao.DAOFactory;


public class PostgresSqlDAOFactoryImpl implements DAOFactory {

    @Override
    public CustomerDAO getCustomerDAO() {
        return new PostgresSqlCustomerDAOImpl();
    }
}
