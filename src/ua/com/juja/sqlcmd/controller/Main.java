package ua.com.juja.sqlcmd.controller;

import ua.com.juja.sqlcmd.controller.command.*;
import ua.com.juja.sqlcmd.controller.command.impl.*;
import ua.com.juja.sqlcmd.controller.controller.impl.MainController;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.model.JDBCDatabaseManager;
import ua.com.juja.sqlcmd.view.Console;
import ua.com.juja.sqlcmd.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new Console();
        DatabaseManager manager = new JDBCDatabaseManager();

        Command commandHelp = new Help(view);
        Command commandExit = new Exit(view);
        Command commandConnect = new Connect(view);
        Command commandCreate = new Create(view);
        Command commandFind = new Find(view);
        Command commandTables = new Tables(view);
        Command commandClear = new Clear(manager, view);


        MainController controller = new MainController(view, manager);
        controller.addCommand(commandHelp);
        controller.addCommand(commandExit);
        controller.addCommand(commandFind);
        controller.addCommand(commandCreate);
        controller.addCommand(commandConnect);
        controller.addCommand(commandTables);
        controller.addCommand(commandClear);


        controller.run();
    }
}
