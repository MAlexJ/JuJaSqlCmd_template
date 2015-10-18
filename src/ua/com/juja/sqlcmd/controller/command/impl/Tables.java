package ua.com.juja.sqlcmd.controller.command.impl;

import ua.com.juja.sqlcmd.controller.command.AbstractCommand;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;

import java.util.Set;

public class Tables extends AbstractCommand implements Command {
    public Tables(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("tables");
    }

    @Override
    public void process(String command) {
        LOG.debug(getClass() + " " + command);
        if (verificationTables(command) && isConnect()) {
                Set<String> tableNames = manager.getTableNames();
                view.write(tableNames.toString());
        }
    }
}
