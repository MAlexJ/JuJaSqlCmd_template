package ua.com.juja.sqlcmd.controller.command.impl;

import ua.com.juja.sqlcmd.controller.command.AbstractCommand;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;

import java.util.ArrayList;

public class Connect extends AbstractCommand implements Command {


    public Connect(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("connect|");
    }

    @Override
    public void process(String command) {
        LOG.debug(getClass() + " " + command);
        if (verificationConnect(command)) {
            String[] dataInput = stringToArrayString(command);
            this.manager.connect(dataInput[1], dataInput[2], dataInput[3]);
            view.write("Успех!");
        }
    }
}
