package ua.com.juja.sqlcmd.dao.test;

import ua.com.juja.sqlcmd.dao.CustomerDAO;
import ua.com.juja.sqlcmd.dao.DAOFactory;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DataSetImpl;

import java.util.Collection;


public class TestMain {


    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
        CustomerDAO dao = daoFactory.getCustomerDAO();
        System.out.println(" dao.connect(\"sqlcmd\", \"postgres\",\"postgres\");");
        dao.connect("sqlcmd", "postgres", "postgres");
        System.out.println("dao.getTableNames() -> " + dao.getTableNames() + "\n");

        Collection<DataSet> collection = dao.find("user");
        for (DataSet dataSet : collection) {
            System.out.print(dataSet.getNames() + "  ");
            System.out.println(dataSet.getValues());

        }

        System.out.println();


        DataSet dataSet = new DataSetImpl();
        dataSet.put("Alex", "2222");
        dao.create("account", dataSet);

        System.out.println("print ->    Collection<DataSet> collection2 = dao.find(\"account\");");

        Collection<DataSet> collection2 = dao.find("account");
        for (DataSet dataSet2 : collection2) {
            System.out.print(dataSet2.getNames() + "  ");
            System.out.println(dataSet2.getValues());

        }


        System.out.println("dao.clear(\"account\");");
        dao.clear("account");
        System.out.println();


        Collection<DataSet> collection3 = dao.find("account");
        for (DataSet dataSet3 : collection3) {
            System.out.print(dataSet3.getNames() + "  ");
            System.out.println(dataSet3.getValues());

        }
        System.out.println("print ->    Collection<DataSet> collection2 = dao.find(\"account\");");
        System.out.println("print ->    collection3.isEmpty() " + collection3.isEmpty());
        System.out.println("exit");

    }
}
