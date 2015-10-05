package ua.com.juja.sqlcmd.controller.command.impl;

import ua.com.juja.sqlcmd.controller.command.AbstractCommand;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.exception.imp.ExitException;
import ua.com.juja.sqlcmd.view.View;

public class Exit extends AbstractCommand implements Command {

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("exit");
    }

    @Override
    public void process(String command) throws ExitException {
        view.write("До скорой встречи!");
        throw new ExitException();
    }
}
