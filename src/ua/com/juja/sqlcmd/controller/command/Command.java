package ua.com.juja.sqlcmd.controller.command;

import ua.com.juja.sqlcmd.exception.JuJaSqlCmdException;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public interface Command {

    boolean canProcess(String command);

    void process(String command) throws JuJaSqlCmdException;
}
