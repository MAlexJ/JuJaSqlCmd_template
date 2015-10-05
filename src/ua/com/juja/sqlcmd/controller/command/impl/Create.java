package ua.com.juja.sqlcmd.controller.command.impl;

import ua.com.juja.sqlcmd.controller.command.AbstractCommand;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.view.View;

/**
 * Created by ION on 05.10.2015.
 */
public class Create extends AbstractCommand implements Command {
    public Create(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("create|");
    }

    @Override
    public void process(String command) {
        LOG.debug(getClass() + " " + command);
    }
}
