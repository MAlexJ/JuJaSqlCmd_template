package ua.com.juja.sqlcmd.controller.controller.impl;

import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.controller.controller.AbstractController;
import ua.com.juja.sqlcmd.controller.controller.Controller;
import ua.com.juja.sqlcmd.exception.JuJaSqlCmdException;
import ua.com.juja.sqlcmd.exception.imp.ExitException;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.model.impl.DatabaseManagerImpl;
import ua.com.juja.sqlcmd.view.View;


public class MainController extends AbstractController implements Controller {
    private DatabaseManager manager;
    private Command[] commandCollection;
    private boolean flagExit = true;

    public MainController(View view, DatabaseManager manager, Command[] commands) {
        this.view = view;
        this.manager = manager;
        this.commandCollection = commands;
    }

    @Override
    public void run() {
        init();
        while (flagExit) {
            try {
                boolean flag = true;
                String request = view.read();
                for (Command command : commandCollection) {
                    if (command.canProcess(request)) {
                        LOG.debug(command.getClass());
                        command.process(request);
                        flag = false;
                    }
                }
                existenceOfCommand(flag, request);
                readLine();
            } catch (ExitException e) {
                if (manager.isConnected()) {
                    manager.close();
                }
                flagExit = false;
            } catch (JuJaSqlCmdException e) {
                LOG.error(e.getMessage());
            }
        }
    }


    private void existenceOfCommand(boolean flag, String request) {
        if (manager.isConnected()) {
            if (flag) unsupported(request);
        } else {
            connectionCheck(request);
        }
    }
}
