package ua.com.juja.sqlcmd.controller;

import ua.com.juja.sqlcmd.controller.command.*;
import ua.com.juja.sqlcmd.controller.command.impl.*;
import ua.com.juja.sqlcmd.controller.controller.impl.MainController;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.model.JDBCDatabaseManager;
import ua.com.juja.sqlcmd.view.impl.Console;
import ua.com.juja.sqlcmd.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new Console();
        DatabaseManager manager = new JDBCDatabaseManager();

        Command[] commands = new Command[]{
                new Help(view),
                new Exit(view),
                new Connect(view),
                new Create(view),
                new Find(view),
                new Tables(view),
                new Clear(manager, view)
        };

        MainController controller = new MainController(view, manager, commands);

        controller.run();
    }
}
