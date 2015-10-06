package ua.com.juja.sqlcmd.dao;


import ua.com.juja.sqlcmd.dao.impl.PostgresSqlDAOFactoryImpl;

/**
 * Created by ION on 07.10.2015.
 */
public interface DAOFactory {
    public static final int POSTGRES = 1;
    public static final int MYSQL = 2;

    public abstract CustomerDAO getCustomerDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {

            case POSTGRES:
                return new PostgresSqlDAOFactoryImpl();

            case MYSQL:
                return null;


            default:
                return null;
        }
    }
}
