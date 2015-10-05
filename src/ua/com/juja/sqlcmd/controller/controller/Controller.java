package ua.com.juja.sqlcmd.controller.controller;

import ua.com.juja.sqlcmd.controller.command.Command;

public interface Controller {

    void addCommand(Command command);

    void run();
}
