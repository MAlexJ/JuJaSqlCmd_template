package ua.com.juja.sqlcmd.controller.command.impl;

import ua.com.juja.sqlcmd.constants.Constants;
import ua.com.juja.sqlcmd.controller.command.AbstractCommand;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;

import java.util.List;
import java.util.Set;

/**
 * Created by ION on 05.10.2015.
 */
public class Find extends AbstractCommand implements Command, Constants {
    public Find(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("find|");
    }

    @Override
    public void process(String command) {
        LOG.debug(getClass() + " " + command);
        if (verificationFind(command) && isConnect()) {
            String[] strings = splitToArray(command);
            List<DataSet> tableData = manager.getTableData(strings[1]);
            printStartFind();
            if (!tableData.isEmpty()) {
                for (DataSet dataSet : tableData) {
                    view.write(("|" + dataSet.get(NAME).toString()) + "|" + dataSet.get(PASSWORD) + "|" + dataSet.get(ID) + "|");
                }
            }
            printEndFind();
        }
    }
}
