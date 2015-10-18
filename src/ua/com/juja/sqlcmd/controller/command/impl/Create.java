package ua.com.juja.sqlcmd.controller.command.impl;

import ua.com.juja.sqlcmd.controller.command.AbstractCommand;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.model.DataSet;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.model.impl.DataSetImpl;
import ua.com.juja.sqlcmd.view.View;

import java.util.ArrayList;

/**
 * Created by ION on 05.10.2015.
 */
public class Create extends AbstractCommand implements Command {
    public Create(DatabaseManager manager, View view) {
        this.view = view;
        this.manager = manager;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("create|");
    }

    @Override
    public void process(String command) {
        LOG.debug(getClass() + " " + command);
        if (verificationCreate(command)) {
            String[] dataInput = stringToArrayString(command);
            DataSet dataSet = new DataSetImpl();
            for (int i = 2; i < dataInput.length; i += 2) {
                int j = i;
                dataSet.put(dataInput[j++], dataInput[j]);
            }
            this.manager.create(dataInput[1], dataSet);
            printCreate(dataSet, dataInput[1]);
        }
    }
}