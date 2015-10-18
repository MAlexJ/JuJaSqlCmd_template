package ua.com.juja.sqlcmd.controller;

import ua.com.juja.sqlcmd.controller.command.*;
import ua.com.juja.sqlcmd.controller.command.impl.*;
import ua.com.juja.sqlcmd.controller.controller.Controller;
import ua.com.juja.sqlcmd.controller.controller.impl.MainController;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.model.sample.JDBCDatabaseManager;
import ua.com.juja.sqlcmd.view.impl.Console;
import ua.com.juja.sqlcmd.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new Console();
        DatabaseManager manager = new JDBCDatabaseManager();
        Command[] commands = new Command[]{
                new Help(view),
                new Exit(view),
                new Connect(manager, view),
                new Create(manager, view),
                new Find(manager, view),
                new Tables(manager, view),
                new Clear(manager, view)
        };
        Controller controller = new MainController(view, manager, commands);
        controller.run();
    }
}
