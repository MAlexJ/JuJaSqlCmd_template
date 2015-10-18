package ua.com.juja.sqlcmd.controller.command;

import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.constants.Constants;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ION on 05.10.2015.
 */
public abstract class AbstractCommand implements Command, Constants {
    public static final Logger LOG = Logger.getLogger(AbstractCommand.class);
    public View view;
    public DatabaseManager manager;

    protected boolean verificationConnect(String str) {
        String[] arrayStr = splitToArray(str);
        int size = arrayStr.length;
        if (size != 4) {
            view.write("Неудача! по причине: Неверно количество параметров разделенных знаком '|', ожидается 4, но есть: " + size);
            view.write("Повтори попытку.");
            return false;
        }
        return true;
    }

    protected boolean verificationFind(String str) {
        String[] arrayStr = splitToArray(str);
        if (arrayStr.length == 2) {
            return true;
        }

        return false;
    }

    protected boolean verificationCreate(String str) {
        String[] arrayStr = splitToArray(str);
        int size = arrayStr.length;
        if (!(size % 2 == 0) || size < 3) {
            view.write("Неудача! по причине: Должно быть четное количество параметров в формате 'create|tableName|column1|value1|column2|value2|...|columnN|valueN\', а ты прислал: \'" + str + "\'");
            view.write("Повтори попытку.");
            return false;
        }
        return true;
    }

    protected boolean verificationTables(String str) {
        return str.equals("tables");
    }

    protected boolean verificationClear(String str) {
        String[] data = splitToArray(str);
        if (data.length == 2) {
            return true;
        }

        view.write("Неудача! по причине: Формат команды 'clear|tableName', а ты ввел: " + str);
        view.write("Повтори попытку.");
        return false;
    }

    protected String[] stringToArrayString(String command) {
        return command.split("\\|");
    }

    protected boolean isConnect() {
        return this.manager.isConnected();
    }

    protected String[] splitToArray(String str) {
        return str.split("\\|");
    }


    protected void printStartFind() {
        view.write("--------------------");
        view.write("|name|password|id|");
        view.write("--------------------");
    }

    protected void printEndFind() {
        view.write("--------------------");
    }

    protected void printCreate(DataSet dataSet, String str) {


        view.write("Запись {names:[id, name, password], values:[" + dataSet.get(ID) + ", " + dataSet.get(NAME) + ", " + dataSet.get(PASSWORD) + "]} была успешно создана в таблице \'" + str + "\'.");
    }

}
