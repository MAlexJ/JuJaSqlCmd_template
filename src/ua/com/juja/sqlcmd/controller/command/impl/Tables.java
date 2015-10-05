package ua.com.juja.sqlcmd.controller.command.impl;

import ua.com.juja.sqlcmd.controller.command.AbstractCommand;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.view.View;

public class Tables extends AbstractCommand implements Command {
    public Tables(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("tables");
    }

    @Override
    public void process(String command) {
        LOG.debug(getClass() + " " + command);
    }
}
